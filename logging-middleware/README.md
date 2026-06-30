## Logging Middleware

A reusable logging middleware developed.

-Reusable logging
-Send logs
-Supports token authentication


## Project Structure

```
logging-middleware/
│
├── LoggerMiddleware.java
└── README.md
```

## Request Body

```json
{
    "stack": "backend",
    "level": "info",
    "package": "service",
    "message": "Application started successfully"
}
```

---

## Supported Values

### Stack

- backend
- frontend

### Level

- debug
- info
- warn
- error
- fatal

### Backend Packages

- cache
- controller
- cron_job
- db
- domain
- handler
- repository
- route
- service

### Frontend Packages

- api
- component
- hook
- page
- state
- style

### Common Packages

- auth
- config
- middleware
- utils

---

### Response Body

```json
{
    "logID": "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx",
    "message": "log created successfully"
}
```