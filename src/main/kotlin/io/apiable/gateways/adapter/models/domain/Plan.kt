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



data class Plan(
    val id: String,
    val apis: List<Api>,
    val rateLimit: RateLimit? = null,
    val integrationId: String? = null
)