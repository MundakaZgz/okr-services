package org.mundaka.okr.resource;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.mundaka.okr.model.Objective;
import org.mundaka.okr.service.ObjectiveService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/objectives")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@Tag(name = "objective", description = "Objectives operations")
@AllArgsConstructor
@Slf4j
public class ObjectiveResources {

    private final ObjectiveService objectiveService;

    @GET
    @APIResponse(
            responseCode = "200",
            description = "Get all objectives",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = Objective.class)
            )
    )
    public Response get() {
        return Response.ok(objectiveService.findAll()).build();
    }

    @POST
    @APIResponse(
            responseCode = "201",
            description = "Objective Created",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Objective.class)
            )
    )
    @APIResponse(
            responseCode = "400",
            description = "Invalid Objective",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Objective already exists for objectiveId",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response post(@NotNull @Valid Objective objective, @Context UriInfo uriInfo) {
        objectiveService.save(objective);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(objective.getObjectiveId())).build();
        return Response.created(uri).entity(objective).build();
    }

}