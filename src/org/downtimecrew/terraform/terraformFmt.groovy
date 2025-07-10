package org.downtimecrew.terraform

def run(Map config) {
    stage('Terraform Format') {
        if (!config?.terraformDir) {
            error "Terraform Format: 'terraformDir' value is null or empty in config map"
        }

        echo "TF_WORKING_DIR: ${config.terraformDir}"
        sh "ls -la ${config.terraformDir}"

        dir(config.terraformDir) {
            sh 'terraform fmt'
        }
    }
}

