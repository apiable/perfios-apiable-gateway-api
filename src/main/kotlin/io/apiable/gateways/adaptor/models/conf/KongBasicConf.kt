package io.apiable.gateways.adaptor.models.conf

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

class KongBasicConf(
    override var type: GatewayConnectionType = GatewayConnectionType.KONG_BASIC,
    val key: String,
    var url: String
) : Conf