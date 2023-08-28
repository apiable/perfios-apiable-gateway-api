package io.apiable.gateways.adapter.models.domain

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
enum class GrantType{
                    CLIENT_CREDENTIAL,AUTH_CODE
}
class CalloutExamples(val curl: String)
data class Client(
    val clientId: String,
    val clientSecret: String,
    var registrationClientUri: String,
    val integrationId: String? = null,
    var redirectUris: List<String>,
    var allowedOrigins: List<String> = emptyList(),
    val postLogoutRedirectUris: List<String> = emptyList(),
    var examples: CalloutExamples? = null
)