package reducers;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MaxPriceReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {

    @Override
    public void reduce(Text key, Iterable<FloatWritable> values, Context context) throws IOException, InterruptedException {
        float max = -10.0f;

        for (FloatWritable value : values) {
            if (value.get() > max) {
                max = value.get();
            }
        }

        context.write(key, new FloatWritable(max));
    }
}
