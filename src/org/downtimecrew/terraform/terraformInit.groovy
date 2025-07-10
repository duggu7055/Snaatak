package org.downtimecrew.terraform

def run(Map config) {
    stage('Terraform Init') {
        def tfDir = config?.terraformDir?.trim()
        def awsCredId = config?.awsCredId?.trim()

        if (!tfDir) {
            error "Terraform Init: 'terraformDir' is missing or empty in config map"
        }
        if (!awsCredId) {
            error "Terraform Init: 'aws_cred_id' is missing or empty in config map"
        }

        echo "Initializing Terraform in: ${tfDir}"
        sh "ls -la ${tfDir}"

        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: awsCredId]]) {
            dir(tfDir) {
                def initCommand = 'terraform init'
                if (config.reconfigure) {
                    initCommand += ' -reconfigure'
                }

                echo "Running: ${initCommand}"
                sh initCommand
            }
        }
    }
}
