package mappers;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import shared.Data;

import java.io.IOException;

public class CategoryCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] lineData = line.split(Data.SEPARATOR);

        context.write(new Text(lineData[Data.CATEGORY]), key);
    }
}
