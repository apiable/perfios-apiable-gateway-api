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
import io.apiable.gateways.adapter.models.conf.GatewayType

class KongRateLimit(
    override var type: GatewayType = GatewayType.KONG,
    val second: Long? = null,
    val hour: Long? = null,
    val minute: Long? = null,
    val day: Long? = null,
    val month: Long? = null,
    val year: Long? = null
) : RateLimit