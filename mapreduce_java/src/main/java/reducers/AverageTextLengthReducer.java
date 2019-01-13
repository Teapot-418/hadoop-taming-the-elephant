package reducers;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AverageTextLengthReducer extends Reducer<Text, Text, Text, FloatWritable> {

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int resultCount = 0;
        int charCount = 0;

        for (Text value : values) {
            resultCount++;
            charCount += value.toString().length();
        }

        float averageLengthPerCategory = (float) charCount / (float) resultCount;

        context.write(key, new FloatWritable(averageLengthPerCategory));
    }

}
