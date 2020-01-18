# File Manager implemented using Play Framework
 
## Features

1. Register using an existing Google account
2. Log in the system
3. Navigate the online file hierarchy
4. Upload local files to the system
5. Download remote files from the system to the local device
6. Create a directory
7. Delete a directory
8. Delete a remote file

## Technical considerations

1. Uses a relational DB (MySQL configured) for storing file hierarchy metadata
2. Actual file data is stored on the disk as binary hash-named files with no extension
3. Authentication is implemented using [play-authenticate](https://github.com/joscha/play-authenticate) plugin, with Google provider registered by default

## Getting started
1. configure own datasource in ```conf/application.conf```
2. define desired third-party authentication providers in ```modules/play-authenticate```
3. configure API keys for the authentication providers (where necessary) in ```conf/play-authenticate/mime.conf```
4. create folder ```userdata``` in the root of the project for storage of files' data
5. ```sbt run```