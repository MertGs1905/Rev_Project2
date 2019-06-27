import { Injectable } from '@angular/core';
<<<<<<< HEAD
// // import * as AWS from 'aws-sdk/global';
// import * as S3 from 'aws-sdk/clients/s3';
||||||| merged common ancestors
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';
=======
import * as AWS from 'aws-sdk';
import * as S3 from 'aws-sdk/clients/s3';
>>>>>>> c7a37ff1c5f8be84fdf1c5b78cc5fc1be098c083

@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor() { }

  uploadFile(file) {
        const contentType = file.type;
      //   const bucket = new S3(
      //     {
      //         accessKeyId: 'YOUR-ACCESS-KEY-ID',
      //         secretAccessKey: 'YOUR-SECRET-ACCESS-KEY',
      //         region: 'YOUR-REGION'
      //     }
      // );
        const params = {
          Bucket: 'YOUR-BUCKET-NAME',
          Key: file.name,
          Body: file,
          ACL: 'public-read',
          ContentType: contentType
      };
      //   bucket.upload(params, (err, data) => {
      //     if (err) {
      //         console.log('There was an error uploading your file: ', err);
      //         return false;
      //     }
      //     console.log('Successfully uploaded file.', data);
      //     return true;
      // });

    }
}
