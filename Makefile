BACKEND_DIR=blog-backend
FRONTEND_DIR=blog-frontend

# ----------------------------
# Commands
# ----------------------------
.PHONY: backend frontend db clean all

# Start PostgreSQL from docker-compose
db:
	@echo "🚀 Starting PostgreSQL container..."
	docker compose down -v
	docker compose up -d

# Delete ALL existing containers (force delete)
clean:
	@echo "🗑️ Removing all containers..."
	docker rm -f $$(docker ps -aq) 2>/dev/null || true

# Run Spring Boot backend with .env variables
backend:
	cd $(BACKEND_DIR) && export $$(cat .env | xargs) && mvn spring-boot:run

# Run Angular frontend
frontend:
	cd $(FRONTEND_DIR) && npm install && ng serve

# Run database + backend + frontend
all:
	@echo "Starting database, backend, and frontend..."
	@$(MAKE) db
	@$(MAKE) backend &
	@$(MAKE) frontend &
	@wait
