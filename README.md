# Java Scheduler Project

## Overview

The Java Scheduler Project is a robust and flexible framework for scheduling and executing tasks. This project is divided into two main repositories:

1. **mainapp**: Manages user interactions and allows users to initialize jobs.
2. **job-service**: Contains the core scheduling framework, including task executors and frequency handlers.

## Repositories

### mainapp

This repository handles the user interface and interactions. It allows users to define and initialize their jobs with specific scheduling requirements.

#### Key Features
- User-friendly interface for job creation
- Job initialization with various frequency types
- REST API for job management

### job-service

This repository contains the core scheduling logic. It manages the execution of tasks based on the schedules defined by users in the `mainapp`.

#### Key Features
- Flexible scheduling framework
- Support for multiple frequency types (hourly, daily, weekly, monthly, yearly, quarterly, half-yearly, custom, and do-not-repeat)
- Efficient task execution
- Extensible architecture for adding new frequency types

## Frequency Types

The scheduler supports the following frequency types:

- **Instant**: Execution starts at the moment.
- **Hourly**: Executes tasks every hour.
- **Daily**: Executes tasks every day at a specified time.
- **Weekly**: Executes tasks on a specified day of the week at a specified time.
- **Monthly**: Executes tasks on a specified day of the month at a specified time.
- **Quarterly**: Executes tasks every three months on a specified day at a specified time.
- **Half-Yearly**: Executes tasks every six months on a specified day at a specified time.
- **Yearly**: Executes tasks every year on a specified day at a specified time.
- **Custom**: Executes tasks at custom intervals specified in days, hours, minutes, etc.
- **Do Not Repeat**: Executes a task once at a specified time.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- SpringBoot
- MySQL

### Installation

Clone the repositories:
- [mainapp](https://github.com/Manoj-Kannan/mainapp.git)
- [job-service](https://github.com/Manoj-Kannan/job-service.git)
