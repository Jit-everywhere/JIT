import React from 'react';

const Components = () => {
  return (
    <div className="p-8 space-y-8">
      {/* Buttons */}
      <div>
        <h2 className="text-2xl font-bold mb-4">Buttons</h2>
        <button className="btn btn-primary">Primary Button</button>
        <button className="btn btn-secondary">Secondary Button</button>
        <button className="btn btn-accent">Accent Button</button>
      </div>

      {/* Inputs */}
      <div>
        <h2 className="text-2xl font-bold mb-4">Inputs</h2>
        <div className="space-y-4">
          {/* Text Input */}
          <div>
            <label htmlFor="text-input" className="block text-lg font-medium mb-2">Text Input</label>
            <input
              id="text-input"
              type="text"
              className="input-base"
              placeholder="Enter text"
            />
          </div>

          {/* Date Input */}
          <div>
            <label htmlFor="date-input" className="block text-lg font-medium mb-2">Date Input</label>
            <input
              id="date-input"
              type="date"
              className="input-base"
            />
          </div>

          {/* Time Input */}
          <div>
            <label htmlFor="time-input" className="block text-lg font-medium mb-2">Time Input</label>
            <input
              id="time-input"
              type="time"
              className="input-base"
            />
          </div>

          {/* Dropdown */}
          <div>
            <label htmlFor="dropdown" className="block text-lg font-medium mb-2">Select Option</label>
            <select
              id="dropdown"
              className="input-base"
            >
              <option value="">Select...</option>
              <option value="option1">Option 1</option>
              <option value="option2">Option 2</option>
            </select>
          </div>

          {/* Small Input */}
          <div>
            <label htmlFor="small-input" className="block text-lg font-medium mb-2">Small Input</label>
            <input
              id="small-input"
              type="text"
              className="input-small"
              placeholder="Small text"
            />
          </div>

          {/* Large Input */}
          <div>
            <label htmlFor="large-input" className="block text-lg font-medium mb-2">Large Input</label>
            <input
              id="large-input"
              type="text"
              className="input-large"
              placeholder="Large text"
            />
          </div>

          {/* Error Input */}
          <div>
            <label htmlFor="error-input" className="block text-lg font-medium mb-2">Error Input</label>
            <input
              id="error-input"
              type="text"
              className="input-error"
              placeholder="Error text"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Components;
