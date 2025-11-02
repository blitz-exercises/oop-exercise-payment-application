# OOP Exercise - Payment Application

## Story

Blitz Creative Studio has grown from a two-person outfit into a bustling team that mixes full-time staff, freelancers, and one-off vendor invoices. Their finance lead, Mira, faces the same headache every Friday: everyone expects money, but the spreadsheets never match. Some contributors are hourly and must be paid strictly for the hours approved; contractors charge by the day on fixed engagements; and occasionally the studio purchases assets (fonts, sample packs, stock video) on unit-price × quantity invoices. Each of these ends up in a different tab with different formulas. When a project is hot, people add columns, rename headers, and copy-paste formulas that stop working the following week.

Leadership wants a single payment pipeline that works for any kind of "thing that gets paid." Mira doesn't want to know what a contributor is—she just wants to ask two questions:

1. How much do we owe?
2. What line should I print on the weekly payout report?

The CTO proposes one contract, called `Payable`, that every payable entity must honor. Every Friday, the system will:

- Build a mixed list of payables: hourly people, day-rate contractors, and per-item invoices.
- Ask each item for the amount due and a printable, human-friendly line showing how the amount was calculated.
- Sum the totals and produce a short report.

No more "if this is a freelancer do X, if that's an invoice do Y." The report logic must treat them uniformly.

## Requirements

### Constraints from Finance:

- Numbers must make sense: rates must be positive, hours/days/quantities must be non-negative, and descriptions must not be blank.
- Hourly workers submit approved hours for the week and a rate.
- Contractors submit approved days for the week and a day rate.
- Invoices list a description, unit price, and quantity.
- Every payable must produce a single-line summary that Mira can paste into the payout report, e.g.:
  - `HourlyEmployee[A. Novak]: 32.0 h × 40.0 = 1280.0`
- The top-level report must compute the grand total by asking each item the same question (no special cases).
- The architecture must be extensible: if next quarter they add "royalties" or "revenue share," the report code should not change.

### Implementation Requirements:

- Model this world with an interface that unifies everything the finance team cares about.
- Ensure strict validation, private state, and a clean printable line for each payable.
- The payout report must be generated with the same loop every time.

## Implementation Tasks

### Task 1: Define the Payable Interface

Create `src/main/java/nl/blitz/oop/payable/Payable.java` with:
- `double calculatePay()` - returns the amount owed
- `String printLine()` - returns a human-readable single-line summary

### Task 2: Implement HourlyEmployee

Create `src/main/java/nl/blitz/oop/payable/HourlyEmployee.java`:
- Implement `Payable` interface
- Fields: `name` (String), `hourlyRate` (double), `approvedHours` (double)
- Constructor validates:
  - Name is not null/blank
  - Hourly rate > 0
  - Approved hours >= 0
- `calculatePay()` returns: `hourlyRate * approvedHours`
- `printLine()` returns format: `HourlyEmployee[Name]: X.X h × X.X = X.X`

### Task 3: Implement Contractor

Create `src/main/java/nl/blitz/oop/payable/Contractor.java`:
- Implement `Payable` interface
- Fields: `name` (String), `dayRate` (double), `approvedDays` (double)
- Constructor validates:
  - Name is not null/blank
  - Day rate > 0
  - Approved days >= 0
- `calculatePay()` returns: `dayRate * approvedDays`
- `printLine()` returns format: `Contractor[Name]: X.X d × X.X = X.X`

### Task 4: Implement InvoiceItem

Create `src/main/java/nl/blitz/oop/payable/InvoiceItem.java`:
- Implement `Payable` interface
- Fields: `description` (String), `unitPrice` (double), `quantity` (int)
- Constructor validates:
  - Description is not null/blank
  - Unit price > 0
  - Quantity >= 0
- `calculatePay()` returns: `unitPrice * quantity`
- `printLine()` returns format: `InvoiceItem[Description]: X × X.X = X.X`

### Task 5: Create Demo Application

Create `src/main/java/nl/blitz/oop/payable/Demo.java`:
- Build a `List<Payable>` containing mixed implementations:
  - At least one `HourlyEmployee`
  - At least one `Contractor`
  - At least one `InvoiceItem`
- Iterate through the list and print each line using `printLine()`
- Calculate and print the grand total by summing `calculatePay()` for each item
- **No `instanceof` checks** - use polymorphism!

## Learning Objectives

- **Interfaces**: Understand how interfaces define contracts that multiple classes can implement
- **Polymorphism**: Learn to treat different types uniformly through a common interface
- **Encapsulation**: Practice private fields with public getters, ensuring data integrity
- **Validation**: Implement proper input validation in constructors
- **Extensibility**: Design a system where new payable types can be added without changing existing code

## Building and Running

### Prerequisites

- Java 21 or higher
- Maven 3.6 or higher

### Build the Project

```bash
mvn clean compile
```

### Run the Demo

```bash
mvn exec:java -Dexec.mainClass="nl.blitz.oop.payable.Demo"
```

### Run Tests (if implemented)

```bash
mvn test
```

## Project Structure

```
oop-exercise-payment-application/
├── pom.xml
├── README.md
├── .gitignore
├── .coderabbit.yaml
└── src/
    └── main/
        └── java/
            └── nl/
                └── blitz/
                    └── oop/
                        └── payable/
                            ├── Payable.java
                            ├── HourlyEmployee.java
                            ├── Contractor.java
                            ├── InvoiceItem.java
                            └── Demo.java
```

## Notes

- This is a learning exercise - implement the code yourself in the `src/` folder
- All fields must be `private`
- Use `final` for fields that shouldn't change
- Throw `IllegalArgumentException` for invalid inputs
- Follow clean code principles: meaningful names, single responsibility, early returns

