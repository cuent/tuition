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

/**
 *
 * @author Xavier Sumba <xavier.sumba93@ucuenca.ec>
 */
public class Formula {

    public static double calculateParameter(String clazz, int m2, int m3, double arancel) {
        return arancel * (mapClass(clazz) * m2 + m3);
    }

    private static double mapClass(String clazz) {
        switch (clazz) {
            case "clase1":
                return 0.25;
            case "clase2":
                return 0.5;
            case "clase3":
                return 0.75;
            case "clase4":
                return 1;
            default:
                return 0;
        }
    }
}
