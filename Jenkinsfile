// pipeline {
// //     agent {
// //         // 只部署在 master 节点上
// //         label 'master'
// //     }
// agent{
// }
//     tools{
//         maven 'maven'
//     }
//      triggers{
//              // 二分钟一次轮询发送
//              pollSCM('H/2 * * * *')
//      }
//     environment {
// //         //温州实例环境变量
// //         WENZHOU_PATH = "/home/wenzhou/warehouse"
// //         //乐清实例环境变量
// //         YUEQING_PATH = "/home/wenzhou/yueqing"
// //         //测试环境路径
// //         DEV_PATH = "/home/test/warehouse"
//
//         MASTER_PATH="D:/work_save/personal/auto"
//     }
//     stages{
//         stage('Build'){
//             steps{
//                 sh 'mvn clean package '
//                 sh 'mvn dockerfile:build'
//             }
//         }
//         stage('master-run'){
//             when{
//                 branch 'master'
//             }
//             steps{
//                 sh 'docker rm -f blog'
//                 sh """
//                     docker run --name blog -d -p 8090:8090  \
//                     -v ${MASTER_PATH}/log:/blog/log \
//                     -v ${MASTER_PATH}/data:/blog/data \
//                     qunchuang/warehouse
//                 """
//             }
//         }
//     }
// //     post {
// //             // 将邮件发送给zzk、青青、婕黎
// //            success {
// //                 mail bcc: '',
// //                 body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>构建次数 : ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL}",
// //                 cc: '',
// //                 charset: 'UTF-8',
// //                 from: "2336276765@qq.com",
// //                 mimeType: 'text/html',
// //                 replyTo: '',
// //                 subject: "项目构建成功 : ${env.JOB_NAME}",
// //                 to: "2336276765@qq.com,924978100@qq.com,531017994@qq.com";
// //            }
// //            // 项目构建失败 则将邮件发送给 zzk、世杰、港钧
// //            failure {
// //                 mail bcc: '',
// //                  body: "<b>Example</b><br>Project: ${env.JOB_NAME} <br>构建此时 : ${env.BUILD_NUMBER} <br> URL de build: ${env.BUILD_URL} <br> 该邮件请勿回复。",
// //                  cc: '',
// //                  charset: 'UTF-8',
// //                  from: "2336276765@qq.com",
// //                  mimeType: 'text/html',
// //                  replyTo: '',
// //                  subject: "项目构建失败 : ${env.JOB_NAME}",
// //                  to: "2336276765@qq.com,1520444164@qq.com,1047791704@qq.com";
// //            }
// //     }
// }
//

// 快速开始
// pipeline {
//     agent any
//     stages {
//         stage('Example') {
//             steps {
//                 echo 'Hello World'
//             }
//         }
//     }
//     post {
//         always {
//             echo 'I will ........!'
//         }
//     }
// }
// 测试二
// pipeline {
//     agent any
//     stages {
//         stage('Example Build') {
//             agent  any
//             steps {
//                 echo 'Hello, Maven'
//                 sh 'mvn --version'
//             }
//         }
//         stage('Example Test') {
//             agent  any
//             steps {
//                 echo 'Hello, JDK'
//                 sh 'java -version'
//             }
//         }
//     }
// }
// post
// pipeline {
//     agent any
//     stages {
//         stage('Example') {
//             steps {
//                 echo 'Hello World'
//             }
//         }
//     }
//     post {
//         always {
//             echo 'I will always say Hello again!'
//         }
//     }
// }

pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.3'
    }
    stages {
        stage('Example') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}