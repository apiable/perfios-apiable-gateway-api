package io.apiable.gateways.adaptor

import io.apiable.gateways.adaptor.models.conf.Conf
import io.apiable.gateways.adaptor.models.domain.*

/**
 * Apiable Oy
 * http://www.apiable.io/
 *
 * (c) Copyright Apiable Oy. All rights reserved.
 *
 * This product is the proprietary and sole property of Apiable Oy.
 * Use, duplication or dissemination is subject to prior written consent of
 * Apiable Oy.
 *
 * Created on 26.04.23
 * @author: Apiable Geeks <geeks@apiable.io>
 *
 */

interface GatewayAdapter {
    /**
     * List services of the Gateway
     *
     * Callout to:
     *    AWS: java-client: listStages of listApis
     *    Kong: GET ${conf.url}/services
     *    Azure: https://management.azure.com/subscriptions/${conf.subscriptionid}/providers/Microsoft.ApiManagement/service?api-version=${conf.version}"
     * */
    fun listServices(conf: Conf): List<Service>

    /**
     * List apis of the Gateway
     *
     * Callout to:
     *    AWS: java-client: listStages of listApis
     *    Kong: GET ${conf.url}/services
     *    Azure: GET https://management.azure.com/subscriptions/${conf.subscriptionid}/providers/Microsoft.ApiManagement/service?api-version=${conf.version}"
     * */
    fun listApis(conf: Conf, serviceid: String): List<Api>

    /**
     * Update Plan on a Gateway
     *
     * Callout to:
     *    AWS: java-client: updateUsagePlan
     *    Kong:
     *       GET ${conf.url}/services/${api.name}/plugins
     *       PATCH {conf.url}/services/${api.name}/plugins/${aclPlugin.id}
     *    Azure:
     *       PUT https://management.azure.com${plan.integrationId}?api-version=${conf.version}
     *       DELETE https://management.azure.com${plan.integrationId}/apis/${api.name}?api-version=${conf.version}
     *       PUT https://management.azure.com${plan.integrationId}/apis/${api.name}?api-version=${conf.version}
     *       PUT https://management.azure.com${plan.integrationId}/policies/policy?api-version=${conf.version}
     * */
    fun updatePlan(conf: Conf, plan: Plan): Plan

    /**
     * Create Plan on a Gateway
     *
     * Callout to:
     *    AWS: java-client: createUsagePlan
     *    Kong: POST ${conf.url}/services/${api.name}/plugins
     *    Azure:
     *       PUT https://management.azure.com${plan.integrationId}?api-version=${conf.version}
     *       DELETE https://management.azure.com${plan.integrationId}/apis/${api.name}?api-version=${conf.version}
     *       PUT https://management.azure.com${plan.integrationId}/apis/${api.name}?api-version=${conf.version}
     *       PUT https://management.azure.com${plan.integrationId}/policies/policy?api-version=${conf.version}
     * */
    fun createPlan(conf: Conf, plan: Plan): Plan

    /**
     * Update Plan on a Gateway
     *
     * Callout to:
     *    AWS: java-client: createUsagePlan
     *    Kong: Kong does not really have plans, but works with plugins configuration, so nothing to do here
     *    Azure: DELETE https://management.azure.com${plan.integrationId}?api-version=${conf.version}
     * */
    fun deletePlan(conf: Conf, plan: Plan)

    /**
     * Ping the Gateway
     *
     * Callout to:
     *    AWS: java-client: listApis
     *    Kong: GET ${conf.url}/services
     *    Azure: GET https://management.azure.com/subscriptions/${conf.subscriptionid}/providers/Microsoft.ApiManagement/service?api-version=${conf.version}"
     * */
    fun ping(conf: Conf): Boolean

    /**
     * Get Documentation for API
     *
     * Callout to:
     *    AWS: java-client: listDocumentation
     *    Kong: tbd
     *    Azure: tbd
     * */
    fun getDocumentation(conf: Conf, id:String, version:String) : String

    /**
     * Get Usage for Subscription/Key
     *
     * Callout to:
     *    AWS: java-client: listTheUsageOfAKey
     *    Kong: not supported, client gets the usage withing the headers after every call
     *    Azure: tbd
     * */
    fun getApiKeyUsage(conf: Conf, subscription: Subscription): ApiKeyUsage

    /**
     * Create a Key
     * Callout to:
     *    AWS: java-client: createKeyForUsagePlan
     *    Kong:
     *       POST ${conf.url}/consumers
     *       POST ${conf.url}/consumers/$username/key-auth
     *       POST ${conf.url}/consumers/$username/plugins
     *    Azure:
     *       PUT https://management.azure.com$url/subscriptions/${subscription.id}?api-version=${conf.version}&appType=portal
     *
     * */
    fun createKey(conf: Conf, subscription: Subscription, clientIdOverride: String? = null, clientSecretOverride: String? = null, appendToToken: Map<String,String>? = null): String

    /**
     * Read the key
     *
     * Callout to:
     *    AWS: java-client: getKeyForSubscription
     *    Kong: tbd
     *    Azure: tbd
     * */
    fun readKey(conf: Conf, subscription: Subscription): String

    /**
     * Revoke the Key
     *
     * Callout to:
     *    AWS: java-client: deleteKey
     *    Kong: DELETE ${conf.url}/consumers/$username
     *    Azure: DELETE: https://management.azure.com${subscription.integrationId}?api-version=${conf.version}"
     * */
    fun revokeKey(conf: Conf, key: String, clientIdOverride: String? = null, clientSecretOverride: String? = null)

    /**
     * Revoke the Key
     *
     * Callout to:
     *    AWS: java-client: deleteKey
     *    Kong:
     *       DELETE ${conf.url}/consumers/$username
     *       POST ${conf.url}/consumers
     *       POST ${conf.url}/consumers/$username/key-auth
     *       POST ${conf.url}/consumers/$username/plugins
     *    Azure:
     *       DELETE: https://management.azure.com${subscription.integrationId}?api-version=${conf.version}
     *       PUT https://management.azure.com$url/subscriptions/${subscription.id}?api-version=${conf.version}&appType=portal
     * */
    fun refreshKey(conf: Conf, key: String, clientIdOverride: String? = null, clientSecretOverride: String? = null, appendToToken: Map<String,String>? = null): String

    /**
     * Creates a Client on a Gateway
     *
     * Callout to:
     *    AWS: not supported: Can be combined with the Apiable Auth Platform - Curity
     *    Kong:
     *       POST ${conf.url}/consumers
     *       POST ${conf.url}/consumers/$username/oauth2/
     *       POST ${conf.url}/consumers/$username/acls
     *       GET ${conf.url}/services/${api.name}/routes
     *    Azure:
     *       not supported yet: Can be combined with the Apiable Auth Platform - Curity
     * */
    fun createClient(conf: Conf, grantType: GrantType, redirectUris: List<String>? = null): Client

    /**
     * Updates a Client on a Gateway
     *
     * Callout to:
     *    AWS: not supported: Can be combined with the Apiable Auth Platform - Curity
     *    Kong:
     *       PATCH: client.registrationClientUri
     *    Azure:
     *       not supported yet: Can be combined with the Apiable Auth Platform - Curity
     * */
    fun updateClient(conf: Conf, client: Client): Client

    /**
     * Updates a Client on a Gateway
     *
     * Callout to:
     *    AWS: not supported: Can be combined with the Apiable Auth Platform - Curity
     *    Kong:
     *       DELETE: ${conf.url}/consumers/$username
     *    Azure:
     *       not supported yet: Can be combined with the Apiable Auth Platform - Curity
     * */
    fun deleteClient(conf: Conf, client: Client)
}



