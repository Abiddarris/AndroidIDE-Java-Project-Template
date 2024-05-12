
import java.util.stream.Stream;
import java.lang.annotation.Annotation;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JunitMain {
    public static void main(String[] args) throws ClassNotFoundException {
        Class[] classes = Stream.of(args[0].split(","))
            .map(v -> {
                try {
                    return Class.forName(v);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            })
            .toArray(Class[]::new);
        
        System.out.printlnrun(classes));
    }
    
     public static final String run(Class... classes){
        Result result = JUnitCore.runClasses(classes);
        
        StringBuilder builder = new StringBuilder()
            .append("Run Count : ")
            .append(result.getRunCount())
            .append("\nFailure Count : ")
            .append(result.getFailureCount())
            .append("\nRun Time : ")
            .append(result.getRunTime())
            .append("\nIgnore Count : ")
            .append(result.getIgnoreCount())
            .append("\nAssumption Failure Count : ")
            .append(result.getAssumptionFailureCount())
            .append("\nSuccessful : ")
            .append(result.wasSuccessful())
            .append("\nFailures : ");
        
        for(Failure failure : result.getFailures()){
            Description description = failure.getDescription();
            
            builder.append("\n\tTest Header : ")
                .append(failure.getTestHeader())
                .append("\n\tDescription : ")
                .append("\n\t\tDisplay Name : ")
                .append(description.getDisplayName())
                .append("\n\t\tIs Suite : ")
                .append(description.isSuite())
                .append("\n\t\tIs Test : ")
                .append(description.isTest())
                .append("\n\t\tTest Count : ")
                .append(description.testCount())
                .append("\n\t\tTest Class : ")
                .append(description.getTestClass())
                .append("\n\t\tClass Name : ")
                .append(description.getClassName())
                .append("\n\t\tMethod Name : ")
                .append(description.getMethodName())
                .append("\n\t\tAnnotations : ");
            for(Annotation annotation : description.getAnnotations()){
                builder.append("\n\t\t\t")
                    .append(annotation);
            } 
            
            String trace = failure.getTrace();
            builder.append("\n\tTrace : ")
                .append(trace);
        }
                 
        return builder.toString();
    }
}
    