package runners;

import mappers.CategoryCountMapper;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import reducers.CategoryCountReducer;
import shared.Runner;

public class CategoryCount implements Runner {

    public void run(String inputPath, String outputPath) throws Exception {

        Job job = Job.getInstance();
        job.setJobName("Category Count");

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path(outputPath));

        job.setMapperClass(CategoryCountMapper.class);
        job.setReducerClass(CategoryCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setJarByClass(CategoryCount.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}