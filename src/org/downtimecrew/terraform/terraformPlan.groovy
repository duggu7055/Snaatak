package org.downtimecrew.terraform

def run(Map config) {
    stage('Terraform Plan') {
        def tfDir = config?.terraformDir?.trim()
        def awsCredId = config?.awsCredId?.trim()

        if (!tfDir) {
            error "Terraform Plan: 'terraformDir' is missing or empty in config map"
        }
        if (!awsCredId) {
            error "Terraform Plan: 'aws_cred_id' is missing or empty in config map"
        }

        echo "Running Terraform Plan in: ${tfDir}"
        sh "ls -la ${tfDir}"

        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: awsCredId]]) {
            dir(tfDir) {
                def cmd = "terraform plan"

                if (config.var_file?.trim()) {
                    cmd += " -var-file=${config.var_file.trim()}"
                }

                if (config.target_resource?.trim()) {
                    cmd += " -target=${config.target_resource.trim()}"
                }

                echo "🔧 Executing: ${cmd}"
                sh cmd
            }
        }
    }
}
