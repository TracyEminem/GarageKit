package com.wanttobuy.garagekit.utils

import com.facebook.imagepipeline.listener.RequestListener
import com.facebook.imagepipeline.request.ImageRequest

/**
 * Created by TracyEminem on 2019-08-16 11:41.
 */
class FrescoTraceListener : RequestListener{
    override fun onUltimateProducerReached(requestId: String?, producerName: String?, successful: Boolean) {

    }

    override fun onRequestStart(request: ImageRequest?, callerContext: Any?, requestId: String?, isPrefetch: Boolean) {
    }

    override fun onProducerFinishWithCancellation(
        requestId: String?,
        producerName: String?,
        extraMap: MutableMap<String, String>?
    ) {
    }

    override fun onRequestFailure(
        request: ImageRequest?,
        requestId: String?,
        throwable: Throwable?,
        isPrefetch: Boolean
    ) {
    }

    override fun onRequestCancellation(requestId: String?) {
    }

    override fun onRequestSuccess(request: ImageRequest?, requestId: String?, isPrefetch: Boolean) {
    }

    override fun requiresExtraMap(requestId: String?): Boolean {
        return false
    }

    override fun onProducerEvent(requestId: String?, producerName: String?, eventName: String?) {
    }

    override fun onProducerFinishWithFailure(
        requestId: String?,
        producerName: String?,
        t: Throwable?,
        extraMap: MutableMap<String, String>?
    ) {
    }

    override fun onProducerStart(requestId: String?, producerName: String?) {
    }

    override fun onProducerFinishWithSuccess(
        requestId: String?,
        producerName: String?,
        extraMap: MutableMap<String, String>?
    ) {
    }
}