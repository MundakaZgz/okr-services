package org.mundaka.okr;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.mundaka.okr.model.Objective;
import org.mundaka.okr.resource.ObjectiveResources;
import org.apache.commons.lang3.RandomStringUtils;
import static org.assertj.core.api.Assertions.assertThat;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(ObjectiveResources.class)
public class ObjectiveResourceTest {

    @Test
    public void getAll() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    public void post() {
        Objective customer = createObjective();
        Objective saved = given()
                .contentType(ContentType.JSON)
                .body(customer)
                .post()
                .then()
                .statusCode(201)
                .extract().as(Objective.class);
        assertThat(saved.getObjectiveId()).isNotNull();
    }

    private Objective createObjective() {
        Objective objective = new Objective();
        objective.setDescription(RandomStringUtils.randomAlphabetic(10));
        return objective;
    }
}