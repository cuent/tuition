-- 
--    Licensed to the Apache Software Foundation (ASF) under one or more
--    contributor license agreements.  See the NOTICE file distributed with
--    this work for additional information regarding copyright ownership.
--    The ASF licenses this file to You under the Apache License, Version 2.0
--    (the "License"); you may not use this file except in compliance with
--    the License.  You may obtain a copy of the License at
--  
--        http://www.apache.org/licenses/LICENSE-2.0
--  
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
-- 

-- Create table with information of students and class
CREATE TABLE STUDENT(PERSON_ID VARCHAR(20) PRIMARY KEY, ES_JEFE BOOLEAN, JEFE_OCUPACION VARCHAR(150), VIVIENDA_TENENCIA VARCHAR(150), VIVIENDA_TIPO VARCHAR(150), NRO_PROPIEDADES VARCHAR(150), INGRESOS VARCHAR(150), EGRESOS VARCHAR(150), NRO_VEHICULOS VARCHAR(150), AVALUO_VEHICULOS VARCHAR(150), NUMINTEGRANTES VARCHAR(150), NUMESTUDIANTRES VARCHAR(150), CLASE VARCHAR(150)) AS SELECT * FROM CSVREAD('src/main/resources/data.csv');

-- Create alias for fulltext searches
CREATE ALIAS IF NOT EXISTS FT_INIT FOR "org.h2.fulltext.FullText.init";
CALL FT_INIT();

-- Index table clase by person_id
CALL FT_CREATE_INDEX('PUBLIC', 'STUDENT', 'PERSON_ID');
