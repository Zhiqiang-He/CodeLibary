/*
 * *
 *  * Licensed to the Apache Software Foundation (ASF) under one or more
 *  * contributor license agreements.  See the NOTICE file distributed with
 *  * this work for additional information regarding copyright ownership.
 *  * The ASF licenses this file to You under the Apache License, Version 2.0
 *  * (the "License"); you may not use this file except in compliance with
 *  * the License.  You may obtain a copy of the License at
 *  *
 *  *    http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.james.codelib.guava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by James.Hez on 2015/9/24.
 */
public class TimeTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        System.out.println(sdf.parse("1970-1-01 00:00:00.000").getTime());//-28800000
        System.out.println(sdf.format(new Date()));//2015-09-24 12:20:39.581
        System.out.println(sdf.parse(sdf.format(new Date())).getTime());//1443068439582
        System.out.println(new Date().getTime());//1443068439582
        System.out.println(System.currentTimeMillis());//1443068439582
        System.out.println("------------------------");
        System.out.println("Change time zone to UTC");
        System.out.println("------------------------");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(sdf.parse("1970-1-01 00:00:00.000").getTime());//0
        System.out.println(new Date(0).getTime());//0
    }
}
