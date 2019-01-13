package runners;

import reducers.CategoryCountReducer;
import mappers.MainCategoryMapper;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import shared.Runner;

public class MainCategoryCount implements Runner {
    @Override
    public void run(String inputPath, String outputPath) throws Exception {
        Job job = Job.getInstance();
        job.setJobName("Main category count");

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path((outputPath)));

        job.setMapperClass(MainCategoryMapper.class);
        job.setReducerClass(CategoryCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setJarByClass(MainCategoryCount.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
