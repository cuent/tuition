/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.ucuenca.tuition.rest;

import edu.ucuenca.tuition.mapping.Formula;
import edu.ucuenca.tuition.mapping.Student;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Xavier Sumba <xavier.sumba93@ucuenca.ec>
 */
@Path("/payment")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class Payment {

    @PersistenceContext
    EntityManager em;

    @GET
    @Path("parameter")
    public Response getPayment(@QueryParam("cedula") String cedula,
            @QueryParam("m2") int m2, @QueryParam("m3") int m3) {
        String clazz = em.createNamedQuery("Student.findClass", String.class)
                .setParameter("person_id", cedula).getSingleResult();
        return Response.ok(Formula.calculateParameter(clazz, m2, m3)).build();
    }

    @GET
    @Path("user")
    public Response findUser(@QueryParam("cedula") String cedula) {
        return Response.ok(
                em.createNamedQuery("Student.findById", Student.class)
                .setParameter("person_id", cedula)
                .getResultList().toArray(new Student[0])).build();
    }

    @GET
    @Path("users")
    public Response getStudents() {
        return Response.ok(em.createNamedQuery("Student.findAll", Student.class).getResultList().toArray(new Student[0])).build();
    }
}
