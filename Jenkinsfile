pipeline {
    agent any

    environment {
        REGISTRY = 'user14.azurecr.io'
        IMAGE_NAME = 'customer'
        AKS_CLUSTER = 'user14-aks'
        RESOURCE_GROUP = 'user14-rsrcgrp'
        AKS_NAMESPACE = 'default'
        AZURE_CREDENTIALS_ID = 'Azure-Cred'
        TENANT_ID = '29d166ad-94ec-45cb-9f65-561c038e1c7a' // Service Principal 등록 후 생성된 ID
    }
 
    stages {
        stage('Clone Repository') {
            steps {
                checkout scm
            }
        }
        
        stage('Maven Build') {
            steps {
                dir("${IMAGE_NAME}"){
                    withMaven(maven: 'Maven') {
                        sh 'mvn package -DskipTests'
                    }
                }
            }
        }
        
        stage('Docker Build') {
            steps {
                dir("${IMAGE_NAME}"){
                    script {
                        image = docker.build("${REGISTRY}/${IMAGE_NAME}:v1")
                    }
                }
            }
        }
        
        stage('Azure Login') {
            steps {
                dir("${IMAGE_NAME}"){
                    script {
                        withCredentials([usernamePassword(credentialsId: env.AZURE_CREDENTIALS_ID, usernameVariable: 'AZURE_CLIENT_ID', passwordVariable: 'AZURE_CLIENT_SECRET')]) {
                            sh 'az login --service-principal -u $AZURE_CLIENT_ID -p $AZURE_CLIENT_SECRET --tenant ${TENANT_ID}'
                        }
                    }
                }
            }
        }
        
        stage('Push to ACR') {
            steps {
                dir("${IMAGE_NAME}"){
                    script {
                        sh "az acr login --name ${REGISTRY.split('\\.')[0]}"
                        sh "docker push ${REGISTRY}/${IMAGE_NAME}:v1"
                    }
                }
            }
        }
        
        stage('CleanUp Images') {
            steps {
                dir("${IMAGE_NAME}"){
                    sh """
                    docker rmi ${REGISTRY}/${IMAGE_NAME}:v1
                    """
                }
            }
        }
        
        stage('Deploy to AKS') {
            steps {
                dir("${IMAGE_NAME}"){
                    script {
                        sh "az aks get-credentials --resource-group ${RESOURCE_GROUP} --name ${AKS_CLUSTER}"
                        sh """
                        sed 's/latest/v${env.BUILD_ID}/g' kubernetes/deployment.yaml > output.yaml
                        cat output.yaml
                        kubectl apply -f output.yaml
                        kubectl apply -f kubernetes/service.yaml
                        rm output.yaml
                        """
                    }
                }
            }
        }
    }
}

