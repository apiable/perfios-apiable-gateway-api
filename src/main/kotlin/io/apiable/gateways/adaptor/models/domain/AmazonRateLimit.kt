package io.apiable.gateways.adaptor.models.domain

import io.apiable.gateways.adaptor.models.conf.GatewayType

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
class AmazonRateLimit(
    override var type: GatewayType = GatewayType.AMAZON,
    var quoteLimit: Int? = null,
    var quotePeriod: Period? = null,
    var throttleBurstLimit: Int? = null,
    var throttleRateLimit: Double? = null,
) : RateLimit

enum class Period{
    WEEK, MONTH, DAY
}