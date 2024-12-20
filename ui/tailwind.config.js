/** @type {import('tailwindcss').Config} */

const plugin = require('tailwindcss/plugin');

module.exports = {
  content: [
    './src/**/*.{html,js,jsx,ts,tsx}',
  ],
  theme: {
    extend: {
      colors: {
        // Beige color palette
        'beige-100': '#fcfaf4',
        'beige-200': '#faf8ef',
        'beige-300': '#f8f4e8',
        'beige-400': '#f7f2e4',
        'beige-500': '#f5efdd',
        'beige-600': '#dfd9c9',
        'beige-700': '#aeaa9d',
        'beige-800': '#87837a',
        'beige-900': '#67645d',

        // Green color palette
        'green-100': '#dfdac7',
        'green-200': '#cfc8ac',
        'green-300': '#b9af86',
        'green-400': '#ac9f6e',
        'green-500': '#97874a',
        'green-600': '#897b43',
        'green-700': '#6b6035',
        'green-800': '#534a29',
        'green-900': '#3f391f',

        // Yellow color palette
        'yellow-100': '#feedc1',
        'yellow-200': '#fde5a3',
        'yellow-300': '#fcd97a',
        'yellow-400': '#fcd160',
        'yellow-500': '#fbc638',
        'yellow-600': '#e4b433',
        'yellow-700': '#b28d28',
        'yellow-800': '#8a6d1f',
        'yellow-900': '#695318',

        // White color palette
        'white-100': '#fefdf9',
        'white-200': '#fdfcf7',
        'white-300': '#fcfbf3',
        'white-400': '#fcfaf1',
        'white-500': '#fbf9ed',
        'white-600': '#e4e3d8',
        'white-700': '#b2b1a8',
        'white-800': '#8a8982',
        'white-900': '#696964',

        // Black color palette
        'black-100': '#b5b4b1',
        'black-200': '#91908c',
        'black-300': '#5f5d57',
        'black-400': '#403d36',
        'black-500': '#100d04',
        'black-600': '#0f0c04',
        'black-700': '#0b0903',
        'black-800': '#090702',
        'black-900': '#070502',
        
        // Alias Colors
        'primary': 'var(--primary-default)',
        'secondary': 'var(--secondary-default)',
        'accent': 'var(--accent-default)',
      },
      fontFamily: {
        primary: ['Inter', 'sans-serif'],
      },
      borderRadius: {
        '0': '0rem',
        '1': '0.4rem',
        '2': '0.8rem',
        '3': '1.2rem',
        '4': '1.6rem',
        'round': '100rem',
      },
      borderWidth: {
        '0': '0rem',
        '1': '0.05rem',
        '2': '0.1rem',
        '3': '0.15rem',
        '4': '0.2rem',
        '10': '0.5rem',
      },
    },
  },
  plugins: [
    require('@tailwindcss/forms'),
    plugin(function({ addComponents, theme }) {
      // Button Styles
      const buttonStyles = {
        '.btn': {
          display: 'inline-block',
          padding: '.8rem 1.5rem',
          borderRadius: theme('borderRadius.1'),
          fontSize: theme('fontSize.base'),
          fontWeight: '600',
          textAlign: 'center',
          cursor: 'pointer',
          textDecoration: 'none',
          transition: 'all 0.3s ease',
        },
        '.btn-primary': {
          backgroundColor: theme('colors.yellow-500'),
          color: theme('colors.white-100'),
          border: `1px solid ${theme('colors.yellow-500')}`,
        },
        '.btn-primary:hover': {
          backgroundColor: theme('colors.yellow-600'),
          borderColor: theme('colors.yellow-600'),
        },
        '.btn-secondary': {
          backgroundColor: theme('colors.green-300'),
          color: theme('colors.white-100'),
          border: `1px solid ${theme('colors.green-300')}`,
        },
        '.btn-secondary:hover': {
          backgroundColor: theme('colors.green-500'),
          borderColor: theme('colors.green-500'),
        },
        '.btn-accent': {
          backgroundColor: theme('colors.black-500'),
          color: theme('colors.white-100'),
          border: `1px solid ${theme('colors.black-500')}`,
        },
        '.btn-accent:hover': {
          backgroundColor: theme('colors.black-600'),
          borderColor: theme('colors.black-600'),
        },
      };

      // Input Styles
      const inputStyles = {
        '.input-base': {
          padding: '.8rem 1.2rem',
          borderRadius: theme('borderRadius.1'),
          border: `1px solid ${theme('colors.gray-300')}`,
          fontSize: theme('fontSize.base'),
          transition: 'all 0.3s ease',
        },
        '.input-base:focus': {
          borderColor: theme('colors.primary'),
          outline: 'none',
        },
        '.input-small': {
          padding: '.6rem 1rem',
          fontSize: theme('fontSize.sm'),
        },
        '.input-large': {
          padding: '1rem 1.5rem',
          fontSize: theme('fontSize.lg'),
        },
        '.input-error': {
          borderColor: theme('colors.red-500'),
          backgroundColor: theme('colors.red-100'),
        },
      };

      addComponents({
        ...buttonStyles,
        ...inputStyles,
      });
    }),
  ],
};
