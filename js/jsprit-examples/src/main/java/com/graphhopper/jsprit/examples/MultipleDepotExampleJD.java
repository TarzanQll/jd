/*
 * Licensed to GraphHopper GmbH under one or more contributor
 * license agreements. See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * GraphHopper GmbH licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.graphhopper.jsprit.examples;

import com.graphhopper.jsprit.analysis.toolbox.AlgorithmSearchProgressChartListener;
import com.graphhopper.jsprit.analysis.toolbox.GraphStreamViewer;
import com.graphhopper.jsprit.analysis.toolbox.Plotter;
import com.graphhopper.jsprit.analysis.toolbox.StopWatch;
import com.graphhopper.jsprit.core.algorithm.VehicleRoutingAlgorithm;
import com.graphhopper.jsprit.core.algorithm.box.Jsprit;
import com.graphhopper.jsprit.core.algorithm.listener.VehicleRoutingAlgorithmListeners.Priority;
import com.graphhopper.jsprit.core.problem.Capacity;
import com.graphhopper.jsprit.core.problem.Location;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem;
import com.graphhopper.jsprit.core.problem.VehicleRoutingProblem.FleetSize;
import com.graphhopper.jsprit.core.problem.job.Service;
import com.graphhopper.jsprit.core.problem.solution.VehicleRoutingProblemSolution;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleImpl;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleType;
import com.graphhopper.jsprit.core.problem.vehicle.VehicleTypeImpl;
import com.graphhopper.jsprit.core.reporting.SolutionPrinter;
import com.graphhopper.jsprit.core.util.Coordinate;
import com.graphhopper.jsprit.core.util.Solutions;
import com.graphhopper.jsprit.instance.reader.CordeauReader;
import com.graphhopper.jsprit.util.Examples;

import java.util.Collection;


public class MultipleDepotExampleJD {


    public static void main(String[] args) {

        Examples.createOutputFolder();
        // 路径规划问题入口
        VehicleRoutingProblem.Builder vrpBuilder = VehicleRoutingProblem.Builder.newInstance();

//        VehicleImpl.Builder vehicleBuilder1 = VehicleImpl.Builder.newInstance("vehicles@[10,10]");
//        vehicleBuilder1.setStartLocation(loc(Coordinate.newInstance(10, 10))).setReturnToDepot(false);
//        vehicleBuilder1.setType(vehicleType);
//        VehicleImpl vehicle1 = vehicleBuilder1.build();

        // 订单信息,主要是经纬度/重量/大小/服务时间等
        String id1 = "1";
        Coordinate customerCoord1 = new Coordinate(-99.0, -97.0);
        double serviceTime1 = 0.0;
        int demand1 = 6;
        int size1 = 5;
        Service service1 = Service.Builder.newInstance(id1).addSizeDimension(0, demand1)
            .addSizeDimension(1, size1).setServiceTime(serviceTime1)
            .setLocation(Location.Builder.newInstance().setId(id1).setCoordinate(customerCoord1).build()).build();
        vrpBuilder.addJob(service1);

        String id2 = "2";
        Coordinate customerCoord2 = new Coordinate(-59.0, 50.0);
        double serviceTime2 = 0.0;
        int demand2 = 72;
        int size2 = 5;
        Service service2 = Service.Builder.newInstance(id2).addSizeDimension(0, demand2)
            .addSizeDimension(1, size2).setServiceTime(serviceTime2)
            .setLocation(Location.Builder.newInstance().setId(id2).setCoordinate(customerCoord2).build()).build();
        vrpBuilder.addJob(service2);

        String id3 = "3";
        Coordinate customerCoord3 = new Coordinate(-0.0, 14.0);
        double serviceTime3 = 0.0;
        int demand3 = 52;
        int size3 = 5;
        Service service3 = Service.Builder.newInstance(id3).addSizeDimension(0, demand3)
            .addSizeDimension(1, size3).setServiceTime(serviceTime3)
            .setLocation(Location.Builder.newInstance().setId(id3).setCoordinate(customerCoord3).build()).build();
        vrpBuilder.addJob(service3);

        String id4 = "4";
        Coordinate customerCoord4 = new Coordinate(-17.0, -66.0);
        double serviceTime4 = 0.0;
        int demand4 = 12;
        int size4 = 5;
        Service service4 = Service.Builder.newInstance(id4).addSizeDimension(0, demand4)
            .addSizeDimension(1, size4).setServiceTime(serviceTime4)
            .setLocation(Location.Builder.newInstance().setId(id4).setCoordinate(customerCoord4).build()).build();
        vrpBuilder.addJob(service4);

        String id5 = "5";
        Coordinate customerCoord5 = new Coordinate(-69.0, -19.0);
        double serviceTime5 = 0.0;
        int demand5 = 60;
        int size5 = 5;
        Service service5 = Service.Builder.newInstance(id5).addSizeDimension(0, demand5)
            .addSizeDimension(1, size5).setServiceTime(serviceTime5)
            .setLocation(Location.Builder.newInstance().setId(id5).setCoordinate(customerCoord5).build()).build();
        vrpBuilder.addJob(service5);

        String id6 = "6";
        Coordinate customerCoord6 = new Coordinate(-31.0, -12.0);
        double serviceTime6 = 0.0;
        int demand6 = 1;
        int size6 = 5;
        Service service6 = Service.Builder.newInstance(id6).addSizeDimension(0, demand6)
            .addSizeDimension(1, size6).setServiceTime(serviceTime6)
            .setLocation(Location.Builder.newInstance().setId(id6).setCoordinate(customerCoord6).build()).build();
        vrpBuilder.addJob(service6);

        String id7 = "7";
        Coordinate customerCoord7 = new Coordinate(5.0, -41.0);
        double serviceTime7 = 0.0;
        int demand7 = 70;
        int size7 = 5;
        Service service7 = Service.Builder.newInstance(id7).addSizeDimension(0, demand7)
            .addSizeDimension(1, size7).setServiceTime(serviceTime7)
            .setLocation(Location.Builder.newInstance().setId(id7).setCoordinate(customerCoord7).build()).build();
        vrpBuilder.addJob(service7);

        String id8 = "8";
        Coordinate customerCoord8 = new Coordinate(-12.0, 10.0);
        double serviceTime8 = 0.0;
        int demand8 = 30;
        int size8 = 5;
        Service service8 = Service.Builder.newInstance(id8).addSizeDimension(0, demand8)
            .addSizeDimension(1, size8).setServiceTime(serviceTime8)
            .setLocation(Location.Builder.newInstance().setId(id8).setCoordinate(customerCoord8).build()).build();
        vrpBuilder.addJob(service8);

        String id9 = "9";
        Coordinate customerCoord9 = new Coordinate(-64.0, 77.0);
        double serviceTime9 = 0.0;
        int demand9 = 24;
        int size9 = 5;
        Service service9 = Service.Builder.newInstance(id9).addSizeDimension(0, demand9)
            .addSizeDimension(1, size9).setServiceTime(serviceTime9)
            .setLocation(Location.Builder.newInstance().setId(id9).setCoordinate(customerCoord9).build()).build();
        vrpBuilder.addJob(service9);

        String id10 = "10";
        Coordinate customerCoord10 = new Coordinate(-12.0, 85.0);
        double serviceTime10 = 0.0;
        int demand10 = 80;
        int size10 = 5;
        Service service10 = Service.Builder.newInstance(id10).addSizeDimension(0, demand10)
            .addSizeDimension(1, size10).setServiceTime(serviceTime10)
            .setLocation(Location.Builder.newInstance().setId(id10).setCoordinate(customerCoord10).build()).build();
        vrpBuilder.addJob(service10);


        // 车辆信息 主要是车辆个数/型号/载重/体积/续航能力
        int nuOfVehicles = 5;
        int capacity1 = 100;
        int allsize1 = 60;
        double maxDuration1 = 1000;
        double cost1 = 1;
        int capacity2 = 100;
        int allsize2 = 60;
        double maxDuration2 = 1000;
        double cost2 = 1;
        int capacity3 = 200;
        int allsize3 = 100;
        double maxDuration3 = 2000;
        double cost3 = 1.8;
        int capacity4 = 200;
        int allsize4 = 100;
        double maxDuration4 = 2000;
        double cost4 = 1.8;

        Coordinate firstDepotCoord = Coordinate.newInstance(-33, 33);

        VehicleType vehicleType1 = VehicleTypeImpl.Builder.newInstance(firstDepotCoord + "_type")
            .addCapacityDimension(1, allsize1)
            .addCapacityDimension(0, capacity1).setCostPerDistance(cost1).build();
        String vehicleId1 = "1_vehicle";
        VehicleImpl.Builder vehicleBuilder1 = VehicleImpl.Builder.newInstance(vehicleId1);
        vehicleBuilder1.setStartLocation(Location.newInstance(firstDepotCoord.getX(), firstDepotCoord.getY()));
        vehicleBuilder1.setType(vehicleType1);
        vehicleBuilder1.setLatestArrival(maxDuration1);
        VehicleImpl vehicle1 = vehicleBuilder1.build();
        vrpBuilder.addVehicle(vehicle1);

        VehicleType vehicleType2 = VehicleTypeImpl.Builder.newInstance(firstDepotCoord + "_type")
            .addCapacityDimension(1, allsize2)
            .addCapacityDimension(0, capacity2).setCostPerDistance(cost2).build();
        String vehicleId2 = "2_vehicle";
        VehicleImpl.Builder vehicleBuilder2 = VehicleImpl.Builder.newInstance(vehicleId2);
        vehicleBuilder2.setStartLocation(Location.newInstance(firstDepotCoord.getX(), firstDepotCoord.getY()));
        vehicleBuilder2.setType(vehicleType2);
        vehicleBuilder2.setLatestArrival(maxDuration2);
        VehicleImpl vehicle2 = vehicleBuilder2.build();
        vrpBuilder.addVehicle(vehicle2);

        VehicleType vehicleType3 = VehicleTypeImpl.Builder.newInstance(firstDepotCoord + "_type")
            .addCapacityDimension(1, allsize3)
            .addCapacityDimension(0, capacity3).setCostPerDistance(cost3).build();
        String vehicleId3 = "3_vehicle";
        VehicleImpl.Builder vehicleBuilder3 = VehicleImpl.Builder.newInstance(vehicleId3);
        vehicleBuilder3.setStartLocation(Location.newInstance(firstDepotCoord.getX(), firstDepotCoord.getY()));
        vehicleBuilder3.setType(vehicleType3);
        vehicleBuilder3.setLatestArrival(maxDuration3);
        VehicleImpl vehicle3 = vehicleBuilder3.build();
        vrpBuilder.addVehicle(vehicle3);

        VehicleType vehicleType4 = VehicleTypeImpl.Builder.newInstance(firstDepotCoord + "_type")
            .addCapacityDimension(1, allsize4)
            .addCapacityDimension(0, capacity4).setCostPerDistance(cost4).build();
        String vehicleId4 = "4_vehicle";
        VehicleImpl.Builder vehicleBuilder4 = VehicleImpl.Builder.newInstance(vehicleId4);
        vehicleBuilder4.setStartLocation(Location.newInstance(firstDepotCoord.getX(), firstDepotCoord.getY()));
        vehicleBuilder4.setType(vehicleType4);
        vehicleBuilder4.setLatestArrival(maxDuration4);
        VehicleImpl vehicle4 = vehicleBuilder4.build();
        vrpBuilder.addVehicle(vehicle4);


		/*
         * define problem with finite fleet
		 */
        vrpBuilder.setFleetSize(FleetSize.FINITE);

		/*
         * build the problem
		 */
        VehicleRoutingProblem vrp = vrpBuilder.build();

		/*
         * plot to see how the problem looks like
		 */
//		SolutionPlotter.plotVrpAsPNG(vrp, "output/problem08.png", "p08");

		/*
         * solve the problem
		 */
        VehicleRoutingAlgorithm vra = Jsprit.Builder.newInstance(vrp)
            .setProperty(Jsprit.Parameter.FAST_REGRET, "true")
            .setProperty(Jsprit.Parameter.THREADS, "5").buildAlgorithm();
        vra.setMaxIterations(500);
//        vra.getAlgorithmListeners().addListener(new StopWatch(), Priority.HIGH);
//        vra.getAlgorithmListeners().addListener(new AlgorithmSearchProgressChartListener("output/progress.png"));
        Collection<VehicleRoutingProblemSolution> solutions = vra.searchSolutions();

        SolutionPrinter.print(vrp, Solutions.bestOf(solutions), SolutionPrinter.Print.VERBOSE);
//
//        new Plotter(vrp, Solutions.bestOf(solutions)).plot("output/p08_solution.png", "p08");
//
//        new GraphStreamViewer(vrp, Solutions.bestOf(solutions)).setRenderDelay(50).display();
    }

}
