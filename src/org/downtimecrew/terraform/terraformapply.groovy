package org.downtimecrew.terraform
def call(Map args = [:], steps) {
    if (!args.containsKey('envDir')) {
        steps.error "'envDir' parameter is required"
    }

    def autoApprove = args.get('autoApprove', true)
    def awsCredsId  = args.get('awsCredsId', 'aws-central-account-creds')

    steps.stage("Terraform Apply") {

        steps.input message: "Approve Terraform Apply for '${args.envDir}'?", ok: "Apply Now"

        steps.withCredentials([
            [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: awsCredsId]
        ]) {
            steps.dir(args.envDir) {
                def applyCommand = "terraform apply ${autoApprove ? '-auto-approve' : ''}"
                steps.sh applyCommand.trim()
            }
        }
    }
}
