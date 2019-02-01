/*
 * User Protocal API
 * User Protocal API help for commincate between users
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.spaceship.user.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.spaceship.user.client.ApiCallback;
import com.spaceship.user.client.ApiClient;
import com.spaceship.user.client.UserApiException;
import com.spaceship.user.client.ApiResponse;
import com.spaceship.user.client.Configuration;
import com.spaceship.user.client.Pair;
import com.spaceship.user.client.ProgressRequestBody;
import com.spaceship.user.client.ProgressResponseBody;
import com.spaceship.user.client.model.FireSalvoShots;
import com.spaceship.user.client.model.PUser;
import com.spaceship.user.client.model.SalvoShot;

public class GameresourceApi {
	private ApiClient apiClient;

	public GameresourceApi() {
		this(Configuration.getDefaultApiClient());
	}

	public GameresourceApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/* Build call for fireAutoPilotSalvoShotsUsingPOST */
	private com.squareup.okhttp.Call fireAutoPilotSalvoShotsUsingPOSTCall(String gameId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws UserApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/xl-spaceship/user/game/game/{gameId}/auto".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "gameId" + "\\}", apiClient.escapeString(gameId.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
						throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}

		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private com.squareup.okhttp.Call fireAutoPilotSalvoShotsUsingPOSTValidateBeforeCall(String gameId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws UserApiException {

		// verify the required parameter 'gameId' is set
		if (gameId == null) {
			throw new UserApiException(
					"Missing the required parameter 'gameId' when calling fireAutoPilotSalvoShotsUsingPOST(Async)");
		}

		com.squareup.okhttp.Call call = fireAutoPilotSalvoShotsUsingPOSTCall(gameId, progressListener,
				progressRequestListener);
		return call;

	}

	/**
	 * Auto pilot fire against opponent
	 *
	 * @param gameId
	 *            gameId (required)
	 * @return InlineResponse200
	 * @throws UserApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public FireSalvoShots fireAutoPilotSalvoShotsUsingPOST(String gameId) throws UserApiException {
		ApiResponse<FireSalvoShots> resp = fireAutoPilotSalvoShotsUsingPOSTWithHttpInfo(gameId);
		return resp.getData();
	}

	/**
	 * Auto pilot fire against opponent
	 *
	 * @param gameId
	 *            gameId (required)
	 * @return ApiResponse&lt;InlineResponse200&gt;
	 * @throws UserApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public ApiResponse<FireSalvoShots> fireAutoPilotSalvoShotsUsingPOSTWithHttpInfo(String gameId)
			throws UserApiException {
		com.squareup.okhttp.Call call = fireAutoPilotSalvoShotsUsingPOSTValidateBeforeCall(gameId, null, null);
		Type localVarReturnType = new TypeToken<FireSalvoShots>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * Auto pilot fire against opponent (asynchronously)
	 *
	 * @param gameId
	 *            gameId (required)
	 * @param callback
	 *            The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws UserApiException
	 *             If fail to process the API call, e.g. serializing the request
	 *             body object
	 */
	public com.squareup.okhttp.Call fireAutoPilotSalvoShotsUsingPOSTAsync(String gameId,
			final ApiCallback<FireSalvoShots> callback) throws UserApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		com.squareup.okhttp.Call call = fireAutoPilotSalvoShotsUsingPOSTValidateBeforeCall(gameId, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<FireSalvoShots>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}

	/* Build call for fireSalvoShotsUsingPUT */
	private com.squareup.okhttp.Call fireSalvoShotsUsingPUTCall(String gameId, SalvoShot salvoShot,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws UserApiException {
		Object localVarPostBody = salvoShot;

		// create path and map variables
		String localVarPath = "/xl-spaceship/user/game/{gameId}/fire".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "gameId" + "\\}", apiClient.escapeString(gameId.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
						throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}

		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private com.squareup.okhttp.Call fireSalvoShotsUsingPUTValidateBeforeCall(String gameId, SalvoShot salvoShot,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws UserApiException {

		// verify the required parameter 'gameId' is set
		if (gameId == null) {
			throw new UserApiException(
					"Missing the required parameter 'gameId' when calling fireSalvoShotsUsingPUT(Async)");
		}

		// verify the required parameter 'salvoShot' is set
		if (salvoShot == null) {
			throw new UserApiException(
					"Missing the required parameter 'salvoShot' when calling fireSalvoShotsUsingPUT(Async)");
		}

		com.squareup.okhttp.Call call = fireSalvoShotsUsingPUTCall(gameId, salvoShot, progressListener,
				progressRequestListener);
		return call;

	}

	/**
	 * Fire against opponent
	 *
	 * @param gameId
	 *            id (required)
	 * @param salvoShot
	 *            salvoShot (required)
	 * @return InlineResponse200
	 * @throws UserApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public FireSalvoShots fireSalvoShotsUsingPUT(String gameId, SalvoShot salvoShot) throws UserApiException {
		ApiResponse<FireSalvoShots> resp = fireSalvoShotsUsingPUTWithHttpInfo(gameId, salvoShot);
		return resp.getData();
	}

	/**
	 * Fire against opponent
	 *
	 * @param gameId
	 *            id (required)
	 * @param salvoShot
	 *            salvoShot (required)
	 * @return ApiResponse&lt;InlineResponse200&gt;
	 * @throws UserApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public ApiResponse<FireSalvoShots> fireSalvoShotsUsingPUTWithHttpInfo(String gameId, SalvoShot salvoShot)
			throws UserApiException {
		com.squareup.okhttp.Call call = fireSalvoShotsUsingPUTValidateBeforeCall(gameId, salvoShot, null, null);
		Type localVarReturnType = new TypeToken<FireSalvoShots>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * Fire against opponent (asynchronously)
	 *
	 * @param gameId
	 *            id (required)
	 * @param salvoShot
	 *            salvoShot (required)
	 * @param callback
	 *            The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws UserApiException
	 *             If fail to process the API call, e.g. serializing the request
	 *             body object
	 */
	public com.squareup.okhttp.Call fireSalvoShotsUsingPUTAsync(String gameId, SalvoShot salvoShot,
			final ApiCallback<FireSalvoShots> callback) throws UserApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		com.squareup.okhttp.Call call = fireSalvoShotsUsingPUTValidateBeforeCall(gameId, salvoShot, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<FireSalvoShots>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}

	/* Build call for getGameStatusUsingGET */
	private com.squareup.okhttp.Call getGameStatusUsingGETCall(String gameId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws UserApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/xl-spaceship/user/game/{gameId}".replaceAll("\\{format\\}", "json")
				.replaceAll("\\{" + "gameId" + "\\}", apiClient.escapeString(gameId.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = { "application/json" };
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
						throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}

		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private com.squareup.okhttp.Call getGameStatusUsingGETValidateBeforeCall(String gameId,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws UserApiException {

		// verify the required parameter 'gameId' is set
		if (gameId == null) {
			throw new UserApiException(
					"Missing the required parameter 'gameId' when calling getGameStatusUsingGET(Async)");
		}

		com.squareup.okhttp.Call call = getGameStatusUsingGETCall(gameId, progressListener, progressRequestListener);
		return call;

	}

	/**
	 * Get game status
	 *
	 * @param gameId
	 *            id (required)
	 * @return PUser
	 * @throws UserApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public PUser getGameStatusUsingGET(String gameId) throws UserApiException {
		ApiResponse<PUser> resp = getGameStatusUsingGETWithHttpInfo(gameId);
		return resp.getData();
	}

	/**
	 * Get game status
	 *
	 * @param gameId
	 *            id (required)
	 * @return ApiResponse&lt;PUser&gt;
	 * @throws UserApiException
	 *             If fail to call the API, e.g. server error or cannot
	 *             deserialize the response body
	 */
	public ApiResponse<PUser> getGameStatusUsingGETWithHttpInfo(String gameId) throws UserApiException {
		com.squareup.okhttp.Call call = getGameStatusUsingGETValidateBeforeCall(gameId, null, null);
		Type localVarReturnType = new TypeToken<PUser>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

	/**
	 * Get game status (asynchronously)
	 *
	 * @param gameId
	 *            id (required)
	 * @param callback
	 *            The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws UserApiException
	 *             If fail to process the API call, e.g. serializing the request
	 *             body object
	 */
	public com.squareup.okhttp.Call getGameStatusUsingGETAsync(String gameId, final ApiCallback<PUser> callback)
			throws UserApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		com.squareup.okhttp.Call call = getGameStatusUsingGETValidateBeforeCall(gameId, progressListener,
				progressRequestListener);
		Type localVarReturnType = new TypeToken<PUser>() {
		}.getType();
		apiClient.executeAsync(call, localVarReturnType, callback);
		return call;
	}
}
