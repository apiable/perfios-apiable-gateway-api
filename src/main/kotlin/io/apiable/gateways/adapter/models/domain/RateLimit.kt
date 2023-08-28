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
import com.fasterxml.jackson.annotation.*
import io.apiable.gateways.adapter.models.conf.GatewayType

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes(
    JsonSubTypes.Type(value= AmazonRateLimit::class, name="AMAZON"),
    JsonSubTypes.Type(value= KongRateLimit::class, name="KONG")
)
interface RateLimit{
    var type: GatewayType
}