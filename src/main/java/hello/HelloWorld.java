package hello;

import org.joda.time.LocalTime;
import org.simmetrics.SetMetric;
import org.simmetrics.StringMetric;
import org.simmetrics.metrics.CosineSimilarity;
import org.simmetrics.metrics.OverlapCoefficient;
import org.simmetrics.simplifiers.Simplifiers;
import org.simmetrics.tokenizers.Tokenizers;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import static com.google.common.primitives.Ints.asList;
import static org.simmetrics.builders.StringMetricBuilder.with;

public class HelloWorld {
  public static void main(String[] args) {

    LocalTime currentTime = new LocalTime();
    System.out.println("The current local time is: " + currentTime);

    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());

    Maths maths = new Maths();
    System.out.println(maths.addNumbers());

//    String str1 = "This is a sentence. It is made of words";
//    String str2 = "This sentence is similar. It has almost the same words";

//    StringMetric metric = StringMetrics.cosineSimilarity();

//    float result = metric.compare(str1, str2); //0.4767
//    System.out.println(str1 + ". " + str2 + ". " + "The matching score of these 2 sentences is " + result + ". ");

    Set<Integer> scores1 = new HashSet<>(asList(1, 1, 2, 3, 5, 8, 11, 19));
    Set<Integer> scores2 = new HashSet<>(asList(1, 2, 4, 8, 16, 32, 64));

    SetMetric<Integer> metric = new OverlapCoefficient<>();

    float result2 = metric.compare(scores1, scores2); // 0.4285

    System.out.println(result2);


    String str1 = "This is a sentence. It is made of words";
    String str2 = "This sentence is similar. It has almost the same words";

    StringMetric metric2 =
            with(new CosineSimilarity<String>())
                    .simplify(Simplifiers.toLowerCase(Locale.ENGLISH))
                    .simplify(Simplifiers.replaceNonWord())
                    .tokenize(Tokenizers.whitespace())
                    .build();

    float result = metric2.compare(str1, str2); //0.5720

    System.out.println(result);

  }
}
