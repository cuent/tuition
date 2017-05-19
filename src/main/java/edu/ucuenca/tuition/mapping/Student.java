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
package edu.ucuenca.tuition.mapping;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Mapping of students with their respective class.
 *
 * @author Xavier Sumba <xavier.sumba93@ucuenca.ec>
 */
@Entity
@Table(name = "STUDENT")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.person_id = :person_id"),
    @NamedQuery(name = "Student.findClass", query = "SELECT s.clase FROM Student s WHERE s.person_id = :person_id")
})
@XmlRootElement
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PERSON_ID", length = 20)
    private String person_id;

    @Column(name = "ES_JEFE")
    private boolean es_jefe;

    @Column(name = "JEFE_OCUPACION", length = 150)
    private String jefe_ocupacion;

    @Column(name = "VIVIENDA_TENENCIA", length = 150)
    private String vivienda_tendencia;

    @Column(name = "VIVIENDA_TIPO", length = 150)
    private String vivienda_tipo;

    @Column(name = "NRO_PROPIEDADES", length = 150)
    private String nro_propiedades;

    @Column(name = "INGRESOS", length = 150)
    private String ingresos;

    @Column(name = "EGRESOS", length = 150)
    private String egresos;

    @Column(name = "NRO_VEHICULOS", length = 150)
    private String nro_vehiculos;

    @Column(name = "AVALUO_VEHICULOS", length = 150)
    private String avaluo_vehiculos;

    @Column(name = "NUMINTEGRANTES", length = 150)
    private String num_integrantes;

    @Column(name = "NUMESTUDIANTRES", length = 150)
    private String num_estudiantes;

    @Column(name = "CLASE", length = 150)
    private String clase;

    public Student() {
    }

    public Student(String cedula) {
        this.person_id = cedula;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public boolean isEs_jefe() {
        return es_jefe;
    }

    public void setEs_jefe(boolean es_jefe) {
        this.es_jefe = es_jefe;
    }

    public String getJefe_ocupacion() {
        return jefe_ocupacion;
    }

    public void setJefe_ocupacion(String jefe_ocupacion) {
        this.jefe_ocupacion = jefe_ocupacion;
    }

    public String getVivienda_tendencia() {
        return vivienda_tendencia;
    }

    public void setVivienda_tendencia(String vivienda_tendencia) {
        this.vivienda_tendencia = vivienda_tendencia;
    }

    public String getVivienda_tipo() {
        return vivienda_tipo;
    }

    public void setVivienda_tipo(String vivienda_tipo) {
        this.vivienda_tipo = vivienda_tipo;
    }

    public String getNro_propiedades() {
        return nro_propiedades;
    }

    public void setNro_propiedades(String nro_propiedades) {
        this.nro_propiedades = nro_propiedades;
    }

    public String getIngresos() {
        return ingresos;
    }

    public void setIngresos(String ingresos) {
        this.ingresos = ingresos;
    }

    public String getEgresos() {
        return egresos;
    }

    public void setEgresos(String egresos) {
        this.egresos = egresos;
    }

    public String getNro_vehiculos() {
        return nro_vehiculos;
    }

    public void setNro_vehiculos(String nro_vehiculos) {
        this.nro_vehiculos = nro_vehiculos;
    }

    public String getAvaluo_vehiculos() {
        return avaluo_vehiculos;
    }

    public void setAvaluo_vehiculos(String avaluo_vehiculos) {
        this.avaluo_vehiculos = avaluo_vehiculos;
    }

    public String getNum_integrantes() {
        return num_integrantes;
    }

    public void setNum_integrantes(String num_integrantes) {
        this.num_integrantes = num_integrantes;
    }

    public String getNum_estudiantes() {
        return num_estudiantes;
    }

    public void setNum_estudiantes(String num_estudiantes) {
        this.num_estudiantes = num_estudiantes;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return clase + " " + person_id;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student that = (Student) obj;
        if (that.person_id.equals(this.person_id)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.person_id, this.clase);
    }

}
