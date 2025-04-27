
import { useState } from 'react';
import './faq.css';

const faqs = [
  {
    question: "What is Focus Board?",
    answer:
      "Focus Board is a task and project manager built to help you organize tasks, track progress, and power through focused work sessions.",
  },
  {
    question: "Is Focus Board free to use?",
    answer:
      "Yes! Our core features (boards, progress tracking, timers) are 100% free. Premium add-ons are coming soon.",
  },
  {
    question: "Can I use Focus Board on mobile?",
    answer:
      "Absolutely—our responsive web app works on any modern browser. Native apps for iOS/Android are in beta.",
  },
  
];

function FAQSection() {
  const [openIndex, setOpenIndex] = useState(null);

  const toggle = (i) => {
    setOpenIndex(openIndex === i ? null : i);
  };

  return (
    <>
      {faqs.map((f, i) => (
        <div key={i} className="faq-item">
          <div className={`faq-question ${openIndex === i ? 'open' : ''}`}
            onClick={() => toggle(i)}
          >
            <span className="question-text">{f.question}</span>
            <span className="plus">+</span>
          </div>
          {openIndex === i && (<div className="faq-answer"><p>{f.answer}</p></div>)}
        </div>
      ))}

    </>
  );
}

export default FAQSection;
