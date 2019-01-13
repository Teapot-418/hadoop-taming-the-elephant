package reducers;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AveragePriceReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    @Override
    public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        int resultCount = 0;
        float sum = 0;

        for(FloatWritable price : values) {
            resultCount++;
            sum += price.get();
        }

        Float averagePrice = sum / (float) resultCount;

        context.write(key, new FloatWritable(averagePrice));
    }
}
