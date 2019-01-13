package mappers;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import shared.Data;

import java.io.IOException;

public class CategoryItemNameMapper extends Mapper<LongWritable, Text, Text, Text> {

   @Override
   public void map (LongWritable key, Text value, Context context) throws IOException, InterruptedException {
       String line = value.toString();

       String[] lineData = line.split(Data.SEPARATOR);

       context.write(new Text(lineData[Data.CATEGORY]), new Text(lineData[Data.ITEM]));
   }
}
