package yangcdtu.cn.wxshop.common.utils;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@SuppressWarnings("unused")
public class MinioService {
    private final MinioClient minioClient;
    private static final int UPLOAD_EXPIRY = 15 * 60;
    private static final int DOWNLOAD_EXPIRY = 15 * 60;

    public String getUrlForUpload(String bucketName, String objectName) {
        String url;
        try {
            url = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.PUT)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(UPLOAD_EXPIRY)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public String getUrlForDownload(String bucketName, String objectName) {
        String url;
        try {
            url = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(DOWNLOAD_EXPIRY)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public void deleteObject(String bucketName, String objectName){
        try {
            minioClient.removeObject(
                    RemoveObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrlForPhoto(String bucketName, String objectName){
        // 生成预览图片的临时凭证URL
        String url;
        try {
            url = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(DOWNLOAD_EXPIRY)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return url;
    }

    public void putObject(String bucketName, String objectName, InputStream inputStream){
        try {
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
                                    inputStream, -1, 10485760)
                            .build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public InputStream getObject(String bucketName, String objectName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build()
        );
    }

    public void copyObject(String sourceBucketName, String sourceObjectName, String bucketName, String objectName) {
        try {
            minioClient.copyObject(
                    CopyObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .source(
                                    CopySource.builder()
                                            .bucket(sourceBucketName)
                                            .object(sourceObjectName)
                                            .build()
                            )
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadObject(String bucketName, String objectName, String fileName){
        // Upload an JSON file.
        try {
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName).object(objectName).filename(fileName).build());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doesObjectExist(String bucketName, String objectName) {
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
            return true; // Object exists
        } catch (ErrorResponseException e) {
            if (e.errorResponse().code().equals("NoSuchKey")) {
                return false; // Object does not exist
            } else {
                throw new RuntimeException(e); // Other error occurred
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getObjectsNameByBucket(String bucket) {
        return StreamSupport.stream(
                minioClient.listObjects(ListObjectsArgs.builder().bucket(bucket).build()).spliterator(),
                false
        ).map(result -> {
            try {
                return result.get().objectName();
            } catch (ErrorResponseException | ServerException | XmlParserException | NoSuchAlgorithmException |
                     IOException | InvalidResponseException | InvalidKeyException | InternalException |
                     InsufficientDataException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
