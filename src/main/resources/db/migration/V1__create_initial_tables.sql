-- Create inventory-management schema
CREATE SCHEMA IF NOT EXISTS "inventory-management";

-- Create Supplier Table
CREATE TABLE IF NOT EXISTS "inventory-management".supplier (
  id UUID PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  contact_info TEXT,
  address TEXT,
  rating DECIMAL(3,2),
  lead_time INT,
  remarks TEXT
);

-- Create Product Table
CREATE TABLE IF NOT EXISTS "inventory-management".product (
  id UUID PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  manufacturer VARCHAR(255),
  supplier_id UUID,
  sku VARCHAR(255) UNIQUE,
  description TEXT,
  category VARCHAR(255),
  expiry_date DATE,
  quantity_instock INT,
  unit_type VARCHAR(50),
  price_per_unit DECIMAL(10,2),
  currency VARCHAR(3),
  last_supplied DATE,
  last_supplied_quantity INT,
  restock_threshold INT,
  CONSTRAINT fk_supplier FOREIGN KEY (supplier_id) REFERENCES "inventory-management".supplier(id) ON DELETE SET NULL
);

-- Create Order Table
CREATE TABLE IF NOT EXISTS "inventory-management".order (
  id UUID PRIMARY KEY,
  order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  customer_id UUID, -- Can be linked to a Customer table
  total_amount DECIMAL(10,2),
  status VARCHAR(50),
  remarks TEXT
);

-- Create OrderItem Table
CREATE TABLE IF NOT EXISTS "inventory-management".order_item (
  id UUID PRIMARY KEY,
  order_id UUID NOT NULL,
  product_id UUID NOT NULL,
  quantity INT,
  unit_price DECIMAL(10,2),
  subtotal DECIMAL(10,2),
  CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES "inventory-management".order(id) ON DELETE CASCADE,
  CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES "inventory-management".product(id) ON DELETE CASCADE
);

-- Create trigger for automatically calculating subtotal in OrderItem
CREATE OR REPLACE FUNCTION calculate_subtotal() RETURNS TRIGGER AS $$
BEGIN
  NEW.subtotal := NEW.quantity * NEW.unit_price;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create trigger on insert or update to calculate subtotal
CREATE TRIGGER trigger_calculate_subtotal
BEFORE INSERT OR UPDATE ON "inventory-management".order_item
FOR EACH ROW EXECUTE FUNCTION calculate_subtotal();

-- Indexing for performance (optional)
CREATE INDEX IF NOT EXISTS idx_product_supplier ON "inventory-management".product(supplier_id);
CREATE INDEX IF NOT EXISTS idx_order_item_product ON "inventory-management".order_item(product_id);
