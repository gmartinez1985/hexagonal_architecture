# Hexagonal Architecture + DDD

## Description
This is a personal didactic project showcasing a hexagonal architecture implementing the principles of Domain-Driven Design (DDD). The project aims to demonstrate the practical application of these architectural concepts in a clear and educational manner.

## Requirements
- JDK 17: The application requires Java Development Kit version 17 to run. Ensure this version is installed.
- Maven 3.9.2 or higher: It's recommended to have Maven version 3.9.2 or above installed.
- (Optional) Graphviz 9.0.0 or higher: Minimum version of Graphviz required to generate the dependency graph.

## Installation
Steps to install and set up the application locally. This may include dependencies, installation commands, etc.

## Usage

### (Optional) Generating Dependency Graph image

To generate a dependency graph showcasing the project's dependencies using Graphviz, follow these steps:

1. **Install Graphviz**: If not installed, download and install Graphviz from [here](https://www.graphviz.org/download/) using the appropriate method for your operating system. For example, on Windows, you can use Chocolatey with the command:
```bash
choco install graphviz
```

2. **Generate Dependency Graph**: Use the following Maven command to generate a .png file containing the dependency graph:
```bash
mvn depgraph:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.gfmartinez.hexagonalarchitecture*:*"
```
This command generates a visualization of the project's dependencies in a .png format using Graphviz.

The generated .png file will showcase the project's dependency structure.

For generating the dependency graph, the following resources are necessary:
- [depgraph-maven-plugin repository](https://github.com/ferstl/depgraph-maven-plugin?tab=readme-ov-file)
- [depgraph-maven-plugin documentation](https://ferstl.github.io/depgraph-maven-plugin/index.html)

## Configuration
Details on additional configurations, if any. These could be environment variables, configuration files, etc.

## Contribution
Guidelines for others to contribute to the project, including details on how they can open issues, suggest changes, or submit pull requests.

## File Structure
A brief description of the most important file structure within the project.

## License
Specify the license under which the code is distributed.

## Contact
- **Germán Francisco Martínez Navarro**
    - Email: german.f.martinez@gmail.com

## Project Status
An indicator of the project's status, such as if it's in development, in production, etc.

## Examples
If possible, provide visual examples, such as screenshots or animated gifs that demonstrate how it looks or functions.

## Tests and Coverage
- **Testing Framework**: Describe the testing framework used in the project.
- **Running Tests**: Instructions on how to run the tests.
- **Test Coverage**: Information on how test coverage is measured and tracked in the project.

## Deployment
- **Deployment Instructions**: Steps or requirements to deploy the project in a production environment.

## Changelog
- **Change History**: Details of changes in each version of the project.

## Roadmap
- **Roadmap**: Details about future features, improvements, or updates planned fo
