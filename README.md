# intersections

This service calculates the Shortest Path between 2 intersections and also returns the total transit time between them

Usage

In the project's root folder, use sbt run command or you can also use sbt assembly to generate an uber jar and run:

java -cp target/scala-2.12/intersections.jar org.test.intersections.Intersections

First, put the input data (like sample-data.json) in the project's root folder

Then use sbt run

When asked for the Input file, you can just hit Enter to use the default sample-data.json

When asked for start intersection, introduce the starting intersection

Finally when asked for the end intersection, introduce the ending intersection

The service should output the Average transit times, the total transit time and the shortest path

