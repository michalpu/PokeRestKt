package com.michalpu.PokeRest.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.*
import org.springframework.web.client.RequestCallback
import org.springframework.web.client.ResponseExtractor
import org.springframework.web.client.RestOperations
import java.net.URI

class SpyRestTemplate : RestOperations {

    lateinit var get_urlCalledWith: String
    lateinit var stubbedGet: String

    val objectMapper = ObjectMapper().registerModule(KotlinModule())

    override fun <T : Any?> getForEntity(url: String, responseType: Class<T>, vararg uriVariables: Any?): ResponseEntity<T> {
        get_urlCalledWith = url

        return ResponseEntity.ok().body(
                objectMapper.readValue(stubbedGet, responseType)
        )
    }

    override fun <T : Any?> getForEntity(url: String, responseType: Class<T>, uriVariables: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> getForEntity(url: URI, responseType: Class<T>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> postForObject(url: String, request: Any?, responseType: Class<T>, vararg uriVariables: Any?): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> postForObject(url: String, request: Any?, responseType: Class<T>, uriVariables: MutableMap<String, *>): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> postForObject(url: URI, request: Any?, responseType: Class<T>): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun put(url: String, request: Any?, vararg uriVariables: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun put(url: String, request: Any?, uriVariables: MutableMap<String, *>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun put(url: URI, request: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(url: String, method: HttpMethod, requestEntity: HttpEntity<*>?, responseType: Class<T>, vararg uriVariables: Any?): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(url: String, method: HttpMethod, requestEntity: HttpEntity<*>?, responseType: Class<T>, uriVariables: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(url: URI, method: HttpMethod, requestEntity: HttpEntity<*>?, responseType: Class<T>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(url: String, method: HttpMethod, requestEntity: HttpEntity<*>?, responseType: ParameterizedTypeReference<T>, vararg uriVariables: Any?): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(url: String, method: HttpMethod, requestEntity: HttpEntity<*>?, responseType: ParameterizedTypeReference<T>, uriVariables: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(url: URI, method: HttpMethod, requestEntity: HttpEntity<*>?, responseType: ParameterizedTypeReference<T>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(requestEntity: RequestEntity<*>, responseType: Class<T>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> exchange(requestEntity: RequestEntity<*>, responseType: ParameterizedTypeReference<T>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun headForHeaders(url: String, vararg uriVariables: Any?): HttpHeaders {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun headForHeaders(url: String, uriVariables: MutableMap<String, *>): HttpHeaders {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun headForHeaders(url: URI): HttpHeaders {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> getForObject(url: String, responseType: Class<T>, vararg uriVariables: Any?): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> getForObject(url: String, responseType: Class<T>, uriVariables: MutableMap<String, *>): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> getForObject(url: URI, responseType: Class<T>): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> execute(url: String, method: HttpMethod, requestCallback: RequestCallback?, responseExtractor: ResponseExtractor<T>?, vararg uriVariables: Any?): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> execute(url: String, method: HttpMethod, requestCallback: RequestCallback?, responseExtractor: ResponseExtractor<T>?, uriVariables: MutableMap<String, *>): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> execute(url: URI, method: HttpMethod, requestCallback: RequestCallback?, responseExtractor: ResponseExtractor<T>?): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> postForEntity(url: String, request: Any?, responseType: Class<T>, vararg uriVariables: Any?): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> postForEntity(url: String, request: Any?, responseType: Class<T>, uriVariables: MutableMap<String, *>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> postForEntity(url: URI, request: Any?, responseType: Class<T>): ResponseEntity<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun optionsForAllow(url: String, vararg uriVariables: Any?): MutableSet<HttpMethod> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun optionsForAllow(url: String, uriVariables: MutableMap<String, *>): MutableSet<HttpMethod> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun optionsForAllow(url: URI): MutableSet<HttpMethod> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> patchForObject(url: String, request: Any?, responseType: Class<T>, vararg uriVariables: Any?): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> patchForObject(url: String, request: Any?, responseType: Class<T>, uriVariables: MutableMap<String, *>): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T : Any?> patchForObject(url: URI, request: Any?, responseType: Class<T>): T? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postForLocation(url: String, request: Any?, vararg uriVariables: Any?): URI? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postForLocation(url: String, request: Any?, uriVariables: MutableMap<String, *>): URI? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postForLocation(url: URI, request: Any?): URI? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(url: String, vararg uriVariables: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(url: String, uriVariables: MutableMap<String, *>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(url: URI) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
