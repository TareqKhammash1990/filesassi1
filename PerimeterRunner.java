import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
    public int getNumPoints (Shape s){
        // start with last point from shape
        Point point1 = s.getLastPoint();
        // create a counter variable and assign its value to null
        int counter = 0;
        // For each point2 in the shape
        for(Point point2 : s.getPoints()){
        // increase counter variable by; counter = counter +1
            counter = counter + 1;
        // Update point1 to be point2
        point1 = point2;
        }   
        // after excecution of for loop return counter value
        return counter;
        
    }
    
    public double getAverageLength(Shape s){
        int numofsides = getNumPoints(s);
        double Perimeter = getPerimeter(s);
        
        double Averagelength = Perimeter / (double) numofsides;
        
        return Averagelength;
    }
    
    public double getLargestSide(Shape s){
        // define lastpoint (of type Point) to be last point from shape
        Point lastpoint = s.getLastPoint();
        // define largestside to be null (of type double)
        double largestside = 0;
        // for each currentpoint in shape,
        for (Point currentpoint : s.getPoints()){
        // calculate the distance from lastpoint to currentpoint and store it in a variable distance of type double
        double distance = lastpoint.distance(currentpoint);
        // if distance > largestside then largestside = distance
        if(distance > largestside){
        largestside = distance;
        }
        // iterate over shape s, i.e. lastpoint = currentpoint
        lastpoint = currentpoint;
        }
        //return largestside 
        return largestside;
    }
    public double getLargestX(Shape s){
        // define the last point in shape (type Point)
        Point lastpoint = s.getLastPoint();
        // use method getX from this last point and store in variable1 of type double
        double largestX = lastpoint.getX();
        // for each currentpoint in shape
        for (Point currentpoint : s.getPoints()){
        // getX from current point and store in largestX
        double xvalue = currentpoint.getX(); 
        // if variable1 > largestX then largestX = variable1
        if(xvalue > largestX){
            largestX = xvalue;
        }
        
        //currentpoint = lastpoint;
        }
        return largestX;
        
    
    }    
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numofpts = getNumPoints(s);
        double averagelen = getAverageLength(s);
        double largestside = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numofpts);
        System.out.println("The average length of a side in your shape = " +averagelen);
        System.out.println("The largest side of your shape = " + largestside);
        System.out.println("The largest X in the shape = " + largestX);
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
