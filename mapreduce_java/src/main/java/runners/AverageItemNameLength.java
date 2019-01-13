package runners;

import reducers.AverageTextLengthReducer;
import mappers.CategoryItemNameMapper;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import shared.Runner;

public class AverageItemNameLength implements Runner {
    @Override
    public void run(String inputPath, String outputPath) throws Exception {
        Job job = Job.getInstance();
        job.setJobName("Item Name Average Length per Category");

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path((outputPath)));

        job.setMapperClass(CategoryItemNameMapper.class);
        job.setReducerClass(AverageTextLengthReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);

        job.setJarByClass(AverageItemNameLength.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
