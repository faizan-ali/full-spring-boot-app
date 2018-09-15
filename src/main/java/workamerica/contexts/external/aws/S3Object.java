package workamerica.contexts.external.aws;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;

/**
 * Created by Faizan on 8/9/2016.
 */
public class S3Object {

    private static final String bucketName = "";
    private static final String publicBucketName = "";
    private static final Region region = Region.getRegion(Regions.US_WEST_2);

    private static boolean upload(File file, String fileName, String bucket) {
        if (file != null) {
            AmazonS3 s3 = new AmazonS3Client();
            s3.setRegion(region);
            try {
                s3.putObject(new PutObjectRequest(bucket, fileName, file));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void getCompanyImage (Long companyID) {
        AmazonS3 s3 = new AmazonS3Client();
        s3.setRegion(region);
        ObjectListing listing = s3.listObjects(new ListObjectsRequest().withBucketName(bucketName)
                .withPrefix("images/companies/" + companyID).withDelimiter("/"));
        String key = listing.getObjectSummaries().get(0).getKey();
        System.out.println(key);
    }

    public static boolean uploadCompanyImage(File file, String fileName) {
        if (file != null && fileName != null) {
            String directory = "images/companies/" + fileName;
            return upload(file, directory, publicBucketName);
        }
        return false;
    }
}
