package io.swagger.client.api;

import io.swagger.client.ApiInvoker;
import io.swagger.client.ApiException;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.UUID;
import io.swagger.client.model.MapEntryRecord;
import io.swagger.client.model.MapRecord;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class MapsApi {
  String basePath = "https://localhost";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  /**
  * Delete a specific map entry for a specific map
  *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**
   * @param id 
   * @param entryId 
   * @return void
  */
  public void apiV2MapsByIdEntriesByEntryIdDelete (UUID id, UUID entryId) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdDelete",
      new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdDelete"));
      }
  
      // verify the required parameter 'entryId' is set
      if (entryId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdDelete",
      new ApiException(400, "Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdDelete"));
      }
  

  // create path and map variables
  String path = "/Api/v2/Maps/{Id}/Entries/{EntryId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString())).replaceAll("\\{" + "EntryId" + "\\}", apiInvoker.escapeString(entryId.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "Bearer" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return ;
        } else {
           return ;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Delete a specific map entry for a specific map
   *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**
   * @param id    * @param entryId 
  */
  public void apiV2MapsByIdEntriesByEntryIdDelete (UUID id, UUID entryId, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdDelete",
         new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdDelete"));
    }
    
    // verify the required parameter 'entryId' is set
    if (entryId == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdDelete",
         new ApiException(400, "Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdDelete"));
    }
    

    // create path and map variables
    String path = "/Api/v2/Maps/{Id}/Entries/{EntryId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString())).replaceAll("\\{" + "EntryId" + "\\}", apiInvoker.escapeString(entryId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "Bearer" };

    try {
      apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
              responseListener.onResponse(localVarResponse);
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get all specific map entry for a specific map
  * 
   * @param id 
   * @param entryId 
   * @return MapEntryRecord
  */
  public MapEntryRecord apiV2MapsByIdEntriesByEntryIdGet (UUID id, UUID entryId) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdGet",
      new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdGet"));
      }
  
      // verify the required parameter 'entryId' is set
      if (entryId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdGet",
      new ApiException(400, "Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdGet"));
      }
  

  // create path and map variables
  String path = "/Api/v2/Maps/{Id}/Entries/{EntryId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString())).replaceAll("\\{" + "EntryId" + "\\}", apiInvoker.escapeString(entryId.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] {  };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (MapEntryRecord) ApiInvoker.deserialize(localVarResponse, "", MapEntryRecord.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get all specific map entry for a specific map
   * 
   * @param id    * @param entryId 
  */
  public void apiV2MapsByIdEntriesByEntryIdGet (UUID id, UUID entryId, final Response.Listener<MapEntryRecord> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdGet",
         new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdGet"));
    }
    
    // verify the required parameter 'entryId' is set
    if (entryId == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdGet",
         new ApiException(400, "Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdGet"));
    }
    

    // create path and map variables
    String path = "/Api/v2/Maps/{Id}/Entries/{EntryId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString())).replaceAll("\\{" + "EntryId" + "\\}", apiInvoker.escapeString(entryId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((MapEntryRecord) ApiInvoker.deserialize(localVarResponse,  "", MapEntryRecord.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Create or Update an existing map entry in a specific map
  *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**  This both works for updating an existing entry and creating a new entry. The id property of the  model (request body) must match the {EntryId} part of the uri.
   * @param id \&quot;Id\&quot; of the map.
   * @param entryId \&quot;Id\&quot; of the entry that gets inserted.
   * @param record \&quot;Id\&quot; property must match the {EntryId} part of the uri
   * @return UUID
  */
  public UUID apiV2MapsByIdEntriesByEntryIdPut (UUID id, UUID entryId, MapEntryRecord record) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = record;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdPut",
      new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdPut"));
      }
  
      // verify the required parameter 'entryId' is set
      if (entryId == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdPut",
      new ApiException(400, "Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdPut"));
      }
  

  // create path and map variables
  String path = "/Api/v2/Maps/{Id}/Entries/{EntryId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString())).replaceAll("\\{" + "EntryId" + "\\}", apiInvoker.escapeString(entryId.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  "application/json-patch+json","application/json","text/json","application/*+json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "Bearer" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (UUID) ApiInvoker.deserialize(localVarResponse, "", UUID.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Create or Update an existing map entry in a specific map
   *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**  This both works for updating an existing entry and creating a new entry. The id property of the  model (request body) must match the {EntryId} part of the uri.
   * @param id \&quot;Id\&quot; of the map.   * @param entryId \&quot;Id\&quot; of the entry that gets inserted.   * @param record \&quot;Id\&quot; property must match the {EntryId} part of the uri
  */
  public void apiV2MapsByIdEntriesByEntryIdPut (UUID id, UUID entryId, MapEntryRecord record, final Response.Listener<UUID> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = record;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdPut",
         new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesByEntryIdPut"));
    }
    
    // verify the required parameter 'entryId' is set
    if (entryId == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdPut",
         new ApiException(400, "Missing the required parameter 'entryId' when calling apiV2MapsByIdEntriesByEntryIdPut"));
    }
    

    // create path and map variables
    String path = "/Api/v2/Maps/{Id}/Entries/{EntryId}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString())).replaceAll("\\{" + "EntryId" + "\\}", apiInvoker.escapeString(entryId.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      "application/json-patch+json","application/json","text/json","application/*+json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "Bearer" };

    try {
      apiInvoker.invokeAPI(basePath, path, "PUT", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((UUID) ApiInvoker.deserialize(localVarResponse,  "", UUID.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Delete all map entries for a specific map
  *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**
   * @param id 
   * @return void
  */
  public void apiV2MapsByIdEntriesDelete (UUID id) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesDelete",
      new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesDelete"));
      }
  

  // create path and map variables
  String path = "/Api/v2/Maps/{Id}/Entries".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "Bearer" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return ;
        } else {
           return ;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Delete all map entries for a specific map
   *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**
   * @param id 
  */
  public void apiV2MapsByIdEntriesDelete (UUID id, final Response.Listener<String> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesDelete",
         new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesDelete"));
    }
    

    // create path and map variables
    String path = "/Api/v2/Maps/{Id}/Entries".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "Bearer" };

    try {
      apiInvoker.invokeAPI(basePath, path, "DELETE", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
              responseListener.onResponse(localVarResponse);
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get all map entries for a specific map
  * 
   * @param id 
   * @return List<MapEntryRecord>
  */
  public List<MapEntryRecord> apiV2MapsByIdEntriesGet (UUID id) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesGet",
      new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesGet"));
      }
  

  // create path and map variables
  String path = "/Api/v2/Maps/{Id}/Entries".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] {  };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (List<MapEntryRecord>) ApiInvoker.deserialize(localVarResponse, "array", MapEntryRecord.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get all map entries for a specific map
   * 
   * @param id 
  */
  public void apiV2MapsByIdEntriesGet (UUID id, final Response.Listener<List<MapEntryRecord>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesGet",
         new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesGet"));
    }
    

    // create path and map variables
    String path = "/Api/v2/Maps/{Id}/Entries".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((List<MapEntryRecord>) ApiInvoker.deserialize(localVarResponse,  "array", MapEntryRecord.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Create a new map entry in a specific map
  *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**  If you can generate guids client-side, you can also use the PUT variant for both create and update.
   * @param id \&quot;Id\&quot; of the map
   * @param record Do not specify the \&quot;Id\&quot; property. It will be auto-assigned and returned in the response.
   * @return UUID
  */
  public UUID apiV2MapsByIdEntriesPost (UUID id, MapEntryRecord record) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = record;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesPost",
      new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesPost"));
      }
  

  // create path and map variables
  String path = "/Api/v2/Maps/{Id}/Entries".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  "application/json-patch+json","application/json","text/json","application/*+json"
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] { "Bearer" };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (UUID) ApiInvoker.deserialize(localVarResponse, "", UUID.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Create a new map entry in a specific map
   *   * Requires authorization     * Requires any of the following roles: **&#x60;Admin&#x60;**, **&#x60;Developer&#x60;**  If you can generate guids client-side, you can also use the PUT variant for both create and update.
   * @param id \&quot;Id\&quot; of the map   * @param record Do not specify the \&quot;Id\&quot; property. It will be auto-assigned and returned in the response.
  */
  public void apiV2MapsByIdEntriesPost (UUID id, MapEntryRecord record, final Response.Listener<UUID> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = record;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdEntriesPost",
         new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdEntriesPost"));
    }
    

    // create path and map variables
    String path = "/Api/v2/Maps/{Id}/Entries".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      "application/json-patch+json","application/json","text/json","application/*+json"
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] { "Bearer" };

    try {
      apiInvoker.invokeAPI(basePath, path, "POST", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((UUID) ApiInvoker.deserialize(localVarResponse,  "", UUID.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get a specific map
  * 
   * @param id 
   * @return MapRecord
  */
  public MapRecord apiV2MapsByIdGet (UUID id) throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  
      // verify the required parameter 'id' is set
      if (id == null) {
      VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdGet",
      new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdGet"));
      }
  

  // create path and map variables
  String path = "/Api/v2/Maps/{Id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] {  };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (MapRecord) ApiInvoker.deserialize(localVarResponse, "", MapRecord.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get a specific map
   * 
   * @param id 
  */
  public void apiV2MapsByIdGet (UUID id, final Response.Listener<MapRecord> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  
    // verify the required parameter 'id' is set
    if (id == null) {
       VolleyError error = new VolleyError("Missing the required parameter 'id' when calling apiV2MapsByIdGet",
         new ApiException(400, "Missing the required parameter 'id' when calling apiV2MapsByIdGet"));
    }
    

    // create path and map variables
    String path = "/Api/v2/Maps/{Id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "Id" + "\\}", apiInvoker.escapeString(id.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((MapRecord) ApiInvoker.deserialize(localVarResponse,  "", MapRecord.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
  /**
  * Get all maps
  * 
   * @return List<MapRecord>
  */
  public List<MapRecord> apiV2MapsGet () throws TimeoutException, ExecutionException, InterruptedException, ApiException {
     Object postBody = null;
  

  // create path and map variables
  String path = "/Api/v2/Maps".replaceAll("\\{format\\}","json");

  // query params
  List<Pair> queryParams = new ArrayList<Pair>();
      // header params
      Map<String, String> headerParams = new HashMap<String, String>();
      // form params
      Map<String, String> formParams = new HashMap<String, String>();



      String[] contentTypes = {
  
      };
      String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
  

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
      } else {
      // normal form params
        }

      String[] authNames = new String[] {  };

      try {
        String localVarResponse = apiInvoker.invokeAPI (basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames);
        if(localVarResponse != null){
           return (List<MapRecord>) ApiInvoker.deserialize(localVarResponse, "array", MapRecord.class);
        } else {
           return null;
        }
      } catch (ApiException ex) {
         throw ex;
      } catch (InterruptedException ex) {
         throw ex;
      } catch (ExecutionException ex) {
         if(ex.getCause() instanceof VolleyError) {
	    VolleyError volleyError = (VolleyError)ex.getCause();
	    if (volleyError.networkResponse != null) {
	       throw new ApiException(volleyError.networkResponse.statusCode, volleyError.getMessage());
	    }
         }
         throw ex;
      } catch (TimeoutException ex) {
         throw ex;
      }
  }

      /**
   * Get all maps
   * 

  */
  public void apiV2MapsGet (final Response.Listener<List<MapRecord>> responseListener, final Response.ErrorListener errorListener) {
    Object postBody = null;

  

    // create path and map variables
    String path = "/Api/v2/Maps".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();



    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = localVarBuilder.build();
      postBody = httpEntity;
    } else {
      // normal form params
          }

      String[] authNames = new String[] {  };

    try {
      apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType, authNames,
        new Response.Listener<String>() {
          @Override
          public void onResponse(String localVarResponse) {
            try {
              responseListener.onResponse((List<MapRecord>) ApiInvoker.deserialize(localVarResponse,  "array", MapRecord.class));
            } catch (ApiException exception) {
               errorListener.onErrorResponse(new VolleyError(exception));
            }
          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
            errorListener.onErrorResponse(error);
          }
      });
    } catch (ApiException ex) {
      errorListener.onErrorResponse(new VolleyError(ex));
    }
  }
}
