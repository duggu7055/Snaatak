package org.downtimecrew.terraform

def run(Map config) {
    stage('Terraform Validate') {
        def tfDir = config?.terraformDir?.trim()
        if (!tfDir) {
            error "Terraform Validate: 'terraformDir' is missing or empty in config map"
        }

        echo "Validating Terraform in: ${tfDir}"
        sh "ls -la ${tfDir}"

        dir(tfDir) {
            sh 'terraform validate'
        }
    }
}
