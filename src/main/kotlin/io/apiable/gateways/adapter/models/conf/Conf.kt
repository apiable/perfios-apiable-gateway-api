package io.apiable.gateways.adapter.models.conf

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
import com.fasterxml.jackson.annotation.*

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value=AmazonBasicConf::class, name="AMAZON_BASIC"),
    JsonSubTypes.Type(value=AmazonRoleArnConf::class, name="AMAZON_ROLE_ARN"),
    JsonSubTypes.Type(value=KongBasicConf::class, name="KONG_BASIC")
)
interface Conf: java.io.Serializable{
    var type: GatewayConnectionType
}