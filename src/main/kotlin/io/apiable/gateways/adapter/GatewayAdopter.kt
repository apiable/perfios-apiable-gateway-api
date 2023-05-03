package io.apiable.gateways.adapter

import io.apiable.gateways.adapter.models.domain.Api
import io.apiable.gateways.adapter.models.domain.Plan
import io.apiable.gateways.adapter.models.conf.Conf
import io.apiable.gateways.adapter.models.domain.Client

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

interface GatewayAdopter {
    /**
     * List apis of the Gateway
     *
     * @param key The key to connect to the gateway with a persmission of "list-apis readonly"
     * @param secret The secret to connect to the gateway with a persmission of "list-apis readonly"
     * @param url The admin url of the APIGateway to read the apis
     * @return
     */
    fun listApis(conf: Conf): List<Api>
    fun updatePlan(conf: Conf, plan: Plan): Plan
    fun createPlan(conf: Conf, plan: Plan): Plan
    fun deletePlan(conf: Conf, plan: Plan)
    fun ping(conf: Conf): Boolean
    fun getDocumentation(conf: Conf, id:String, version:String) : String
    fun createKey(conf: Conf, clientIdOverride: String? = null, clientSecretOverride: String? = null, appendToToken: Map<String,String>? = null): String
    fun readKey(conf: Conf, subscriptionId: String): String
    fun revokeKey(conf: Conf, key: String, clientIdOverride: String? = null, clientSecretOverride: String? = null)
    fun refreshKey(conf: Conf, key: String, clientIdOverride: String? = null, clientSecretOverride: String? = null, appendToToken: Map<String,String>? = null): String
    fun createClient(conf: Conf, appendToToken: Map<String,String>? = null): Client
    fun deleteClient(conf: Conf, client: Client)
}



