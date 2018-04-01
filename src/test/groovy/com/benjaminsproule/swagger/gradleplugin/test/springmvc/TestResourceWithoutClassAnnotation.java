package com.benjaminsproule.swagger.gradleplugin.test.springmvc;

import static java.util.Collections.singletonList;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benjaminsproule.swagger.gradleplugin.test.model.RequestModel;
import com.benjaminsproule.swagger.gradleplugin.test.model.ResponseModel;
import com.benjaminsproule.swagger.gradleplugin.test.model.SubResponseModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

@Api(tags = "Test", description = "Test resource", authorizations = {@Authorization("basic")})
public class TestResourceWithoutClassAnnotation {

    @ApiOperation("A basic operation")
    @RequestMapping(path = "/root/withoutannotation/basic", method = RequestMethod.GET)
    public String basic() {
        return "";
    }

    @ApiOperation(value = "A default operation")
    @RequestMapping(path = "/root/withoutannotation/default", method = RequestMethod.GET)
    public Response defaultResponse() {
        return Response.ok().build();
    }

    @ApiOperation(value = "A generics operation")
    @RequestMapping(path = "/root/withoutannotation/generics", method = RequestMethod.POST)
    public List<String> generics(@ApiParam List<RequestModel> body) {
        return singletonList("");
    }

    @ApiOperation("Consumes and Produces operation")
    @RequestMapping(path = "/root/withoutannotation/datatype", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Response dataType(@ApiParam RequestModel requestModel) {
        return Response.ok().build();
    }

    @ApiOperation(value = "A response operation", response = ResponseModel.class)
    @RequestMapping(path = "/root/withoutannotation/response", method = RequestMethod.POST)
    public ResponseModel response(@ApiParam List<RequestModel> body) {
        return new ResponseModel();
    }

    @ApiOperation(value = "A response container operation", response = ResponseModel.class, responseContainer = "List")
    @RequestMapping(path = "/root/withoutannotation/responseContainer", method = RequestMethod.POST)
    public List<ResponseModel> responseContainer(@ApiParam List<RequestModel> body) {
        return singletonList(new ResponseModel());
    }

    @ApiOperation("An extended operation")
    @RequestMapping(path = "/root/withoutannotation/extended", method = RequestMethod.GET)
    public SubResponseModel extended() {
        return new SubResponseModel();
    }

    @ApiOperation("A deprecated operation")
    @RequestMapping(path = "/root/withoutannotation/deprecated", method = RequestMethod.GET)
    @Deprecated
    public String deprecated() {
        return "";
    }

    @ApiOperation(value = "An auth operation", authorizations = {
        @Authorization(value = "oauth2", scopes = {
            @AuthorizationScope(scope = "scope", description = "scope description")
        })
    })
    @RequestMapping(path = "/root/withoutannotation/auth", method = RequestMethod.GET)
    public String withAuth() {
        return "";
    }

    @ApiOperation(value = "A model operation")
    @RequestMapping(path = "/root/withoutannotation/model", method = RequestMethod.GET)
    public String model() {
        return "";
    }

    @ApiOperation("An overriden operation")
    @RequestMapping(path = "/root/withoutannotation/overriden", method = RequestMethod.GET)
    public String overriden() {
        return "";
    }

    @ApiOperation(value = "A hidden operation", hidden = true)
    @RequestMapping(path = "/root/withoutannotation/hidden", method = RequestMethod.GET)
    public String hidden() {
        return "";
    }
}
