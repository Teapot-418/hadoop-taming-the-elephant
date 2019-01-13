package runners;

import mappers.MainCategoryItemDescriptionMapper;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import reducers.AverageTextLengthReducer;
import shared.Runner;

public class MainCategoryAverageItemDescriptionLength implements Runner {
    @Override
    public void run(String inputPath, String outputPath) throws Exception {
        Job job = Job.getInstance();
        job.setJobName("Item Description Average Length per Main-Category");

        FileInputFormat.addInputPath(job, new Path(inputPath));
        FileOutputFormat.setOutputPath(job, new Path((outputPath)));

        job.setMapperClass(MainCategoryItemDescriptionMapper.class);
        job.setReducerClass(AverageTextLengthReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FloatWritable.class);

        job.setJarByClass(MainCategoryAverageItemDescriptionLength.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
